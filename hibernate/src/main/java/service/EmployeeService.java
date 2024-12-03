package service;

import dao.EmployeeDao;
import entity.Employee;
import lombok.Cleanup;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

import static util.HibernateUtil.getSessionFactory;

public class EmployeeService {

    private static final EmployeeService INSTANCE = new EmployeeService();

    private final EmployeeDao employeeDao = EmployeeDao.getInstance();

    private EmployeeService() {

    }

    public Optional<Employee> findById(int id) {
        @Cleanup Session session = getSessionFactory().openSession();
        //session.beginTransaction();

        Optional<Employee> result = employeeDao.findById(session, id);

        //session.getTransaction().commit();
        return result;
    }

    public List<String> groupByName() {
        @Cleanup Session session = getSessionFactory().openSession();
        //session.beginTransaction();

        List<Object[]> results = employeeDao.groupByName(session);

        //session.getTransaction().commit();
        return results.stream().map(a -> (String) a[0]).toList();
    }

    // date format "dd-MM-yyyy"
    public List<Employee> findBetween(String first, String second) {
        @Cleanup Session session = getSessionFactory().openSession();
        //session.beginTransaction();

        List<Employee> results = employeeDao.findBetween(session, first, second);

       //session.getTransaction().commit();
        return results;
    }

    public static EmployeeService getInstance() {
        return INSTANCE;
    }
}
