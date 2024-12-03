import database.Table;
import service.EmployeeService;
import util.HibernateUtil;


public class HibernateRunner {

    public static void main(String[] args) {
        var sessionFactory = HibernateUtil.getSessionFactory();
        var instance = EmployeeService.getInstance();

        // Auto-generated table
        Table.insertValues(sessionFactory);

        // Task 2.1
        var first = instance.findById(1);
        System.out.println(first);

        // Task 2.2
        var second = instance.groupByName();
        System.out.println(second);

        // Task 2.3
        var third = instance.findBetween("01-01-2000", "30-12-2004");
        System.out.println(third);


    }
}
