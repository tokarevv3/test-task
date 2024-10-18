package service;

import dao.EmployeeDao;
import dto.EmployeeDto;
import dto.NewEmployeeDto;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeService();

    private final EmployeeDao employeeDao = EmployeeDao.getInstance();

    private EmployeeService() {

    }

    public Optional<EmployeeDto> findById(int id) {
        return employeeDao.findById(id).map(employee ->
                new EmployeeDto(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getDateOfBirth()
                )
        );
    }

    public List<NewEmployeeDto> groupByName() {
        return employeeDao.groupByName().stream().map(
                employee -> new NewEmployeeDto(
                        employee.getId(),
                        employee.getFullName(),
                        employee.getDateOfBirth()
                )).collect(toList());
    }

    public List<EmployeeDto> findBetween(String first, String second) {
        return employeeDao.findBetween(first, second).stream().map(
                employee -> new EmployeeDto(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getDateOfBirth()
                )).collect(toList());
    }

    public static EmployeeService getInstance() {
        return INSTANCE;
    }
}
