import database.Table;
import dto.EmployeeDto;
import service.EmployeeService;

import java.util.List;

import static database.Table.createTable;
import static database.Table.insertValues;

public class Main {
    public static void main(String[] args) {
//        System.out.println(createTable());
//        System.out.println(insertValues());

        // task 2.1
//        var employeeById = EmployeeService.getInstance().findById(2);
//        System.out.println(employeeById.get());

        // task 2.2
//        var employeesByName = EmployeeService.getInstance().groupByName();
//        System.out.println(employeesByName);

        // task 2.3
        var employeesBetween = EmployeeService.getInstance().findBetween("01-01-2000", "31-12-2004");
        System.out.println(employeesBetween);
    }
}
