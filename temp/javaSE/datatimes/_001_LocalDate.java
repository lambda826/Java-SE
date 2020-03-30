package datatimes;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

import static common.utils.PrintUtil.println;

/*

Immutable
Plain date without the time
Doesn't carry any information about the time zone

*/

public class _001_LocalDate {

    public static void main(String[] args) {

        println("Use LocaDate ======");
        // Obtain the current date from the system clock
        LocalDate today = LocalDate.now();
        println(today);
        // Create an instance by using the of static factory method
        LocalDate date = LocalDate.of(2017, 9, 21);
        println(date);
        println("      Year: " + date.getYear());
        println("     Month: " + date.getMonth());
        println("     Month: " + date.getMonthValue());
        println("   Day of Month: " + date.getDayOfMonth());
        println("    Day of Week: " + date.getDayOfWeek());
        println("Length of Month: " + date.lengthOfMonth());
        println("    Is Leapyear: " + date.isLeapYear());
        println();
        println("      Year: " + date.get(ChronoField.YEAR));
        println("     Month: " + date.get(ChronoField.MONTH_OF_YEAR));
        println("   Day of Month: " + date.get(ChronoField.DAY_OF_MONTH));
        println();

        println("Use LocalTime ======");
        LocalTime time = LocalTime.of(13, 45, 20); // 13:45:20
        println(time);
        println("                             Hour: " + time.getHour());
        println("    Minute: " + time.getMinute());
        println("    Second: " + time.getSecond());
        println();

        println("Use LocalDateTime ======");
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
        println();

        println("Use instant ======");
        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        Instant now = Instant.now();
        println();

    }

}
