package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    public static LocalDate dateFormat(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return  LocalDate.parse(date, formatter);
    }
}
