package dao;

import entity.Employee;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

import static date.DateFormatter.*;

public class EmployeeDao {

    private static final EmployeeDao INSTANCE = new EmployeeDao();

    public static final String FIND_BY_ID = "SELECT e from Employee e where id = :id";

    public static final String GROUP_BY_NAME = "SELECT e.firstName, count(e) from Employee e group by e.firstName";

    public static final String FIND_BETWEEN = "SELECT e from Employee e WHERE dateOfBirth BETWEEN :first AND :second";

    private EmployeeDao() {

    }

    public Optional<Employee> findById(Session session, int id) {
        return session.createQuery(FIND_BY_ID, Employee.class)
                .setParameter("id", id)
                .uniqueResultOptional();
    }

    public List<Object[]> groupByName(Session session) {
        return session.createQuery(GROUP_BY_NAME, Object[].class)
                .getResultList();
    }

    public List<Employee> findBetween(Session session, String first, String second) {
        return session.createQuery(FIND_BETWEEN, Employee.class)
                .setParameter("first", dateFormat(first))
                .setParameter("second", dateFormat(second))
                .list();
    }

    public static EmployeeDao getInstance() {
        return INSTANCE;
    }
}
