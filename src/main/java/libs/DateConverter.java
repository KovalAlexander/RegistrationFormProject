package libs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    public static String getYesterdayDate() {
        LocalDate date = LocalDate.now().minusDays(1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        return date.format(format);
    }

    public static String getTomorrowDate() {
        LocalDate date = LocalDate.now().plusDays(1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        return date.format(format);
    }

    public static String getCurrentDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        return date.format(format);
    }
}

