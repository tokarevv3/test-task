package service;

import dao.EmployeeDao;
import entity.Employee;
import entity.NewEmployee;

import java.util.List;
import java.util.Optional;

public class EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeService();

    private final EmployeeDao employeeDao = EmployeeDao.getInstance();

    private EmployeeService() {

    }

    public Optional<Employee> findById(int id) {
        return employeeDao.findById(id);
    }

    public List<NewEmployee> groupByName() {
        return employeeDao.groupByName();
    }

    // date format "dd-MM-yyyy"
    public List<Employee> findBetween(String first, String second) {
        return employeeDao.findBetween(first, second);
    }

    public static EmployeeService getInstance() {
        return INSTANCE;
    }
}
