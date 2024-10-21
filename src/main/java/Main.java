import service.EmployeeService;

import static database.Table.createTable;
import static database.Table.insertValues;

public class Main {
    public static void main(String[] args) {
        // create and fill database
//        System.out.println(createTable());
//        System.out.println(insertValues());

        // task 2.1
        var employeeById = EmployeeService.getInstance().findById(11);
        System.out.println(employeeById);

        // task 2.2
        var employeesByName = EmployeeService.getInstance().groupByName();
        System.out.println(employeesByName);

        // task 2.3
        var employeesBetween = EmployeeService.getInstance().findBetween("01-01-2000", "30-12-2004");
        System.out.println(employeesBetween);
    }
}
