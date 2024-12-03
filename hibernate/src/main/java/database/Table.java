package database;

import entity.Employee;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import static date.DateFormatter.dateFormat;

public class Table {

    public static void insertValues(SessionFactory sessionFactory) {

        @Cleanup Session session = sessionFactory.openSession();
        saveEmployee(session, "Ivan", "Fadeev","03-03-2000", "1C", 15000);
        saveEmployee(session,"Andrew", "Goroj", "22-12-1996", "1B", 12305);
        saveEmployee(session,"Alla", "Mohnatova", "16-07-2006", "1A", 9500);
        saveEmployee(session,"Eugen", "Fedotov", "09-01-2002", "1B", 12500);
        saveEmployee(session, "Abba", "Ohha", "06-06-2003", "1A", 14800);
        saveEmployee(session,"SonOf", "Director", "23-09-2005", "1A", 255500);
        saveEmployee(session,"Orha", "Gemma", "05-02-1992", "1C", 17850);
        saveEmployee(session,"Alex", "Gutther", "30-11-1995", "1B", 15001);
        saveEmployee(session,"Victor", "Bochka", "22-05-2001", "1C", 13000);
        saveEmployee(session, "Alla", "Pugacheva", "15-04-1949", "1A", 12);
        saveEmployee(session, "Ivan", "Klementev", "05-10-2003", "1C", 15403);
        saveEmployee(session, "Ivan", "Bobryanski", "14-07-2004", "1B", 11054);
    }

    private static void saveEmployee(Session session,
                                     String firstName,
                                     String lastName,
                                     String dateOfBirth,
                                     String department,
                                     Integer salary) {
        Employee employee = Employee.builder()
                .firstName(firstName)
                .lastName(lastName)
                .dateOfBirth(dateFormat(dateOfBirth))
                .department(department)
                .salary(new BigDecimal(salary))
                .build();

        session.save(employee);
    }
}
