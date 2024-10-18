package dao;

import entity.Employee;
import util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao {
    private static final EmployeeDao INSTANCE = new EmployeeDao();

    public static final String FIND_BY_ID = "SELECT * FROM Employee WHERE id=?";

    public static final String GROUP_BY_NAME = "SELECT * FROM Employee GROUP BY firstName ";

    public static final String FIND_BETWEEN = "SELECT * FROM Employee WHERE dateOfBirth BETWEEN ? AND ?";

    private EmployeeDao() {

    }

    public Optional<Employee> findById(int id) {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_BY_ID)) {
            prepareStatement.setLong(1, id);

            var resultSet = prepareStatement.executeQuery();
            Employee employee = null;

            if (resultSet.next()) {
                employee = buildEmployee(resultSet);
            }

            return Optional.ofNullable(employee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> groupByName() {
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(GROUP_BY_NAME)) {

            var resultSet = prepareStatement.executeQuery();
            List<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                employees.add(buildEmployee(resultSet));
            }

            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> findBetween(String first, String second) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Timestamp firstTimestamp = null;
        Timestamp secondTimestamp = null;
        try {
            java.util.Date firstDate = dateFormat.parse(first);
            java.util.Date secondDate = dateFormat.parse(second);
            firstTimestamp = new Timestamp(firstDate.getTime());
            secondTimestamp = new Timestamp(secondDate.getTime());
        } catch (ParseException e) {
            System.out.println("Wrong date format: " + e.getMessage());
            return new ArrayList<>();
        }
        try (var connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_BETWEEN)) {
            prepareStatement.setTimestamp(1, firstTimestamp);
            prepareStatement.setTimestamp(2, secondTimestamp);

            var resultSet = prepareStatement.executeQuery();
            List<Employee> employees = new ArrayList<>();

            while (resultSet.next()) {
                employees.add(buildEmployee(resultSet));
            }

            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static EmployeeDao getInstance() {
        return INSTANCE;
    }

    private static Employee buildEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("firstName", String.class),
                resultSet.getObject("lastName", String.class),
                resultSet.getObject("dateOfBirth", Timestamp.class).toLocalDateTime(),
                resultSet.getObject("department", String.class),
                resultSet.getObject("salary", Integer.class));

    }
}
