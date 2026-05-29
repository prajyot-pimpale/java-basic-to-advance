import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {
    public static void main(String[] args) {

        // Current date
        LocalDate today = LocalDate.now();
        System.out.println("Today    : " + today);         // 2024-01-15

        // Current time
        LocalTime now = LocalTime.now();
        System.out.println("Time     : " + now);           // 14:30:25.123

        // Current date + time
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("DateTime : " + dt);

        // Specific date
        LocalDate dob = LocalDate.of(2000, 6, 15);
        System.out.println("DOB      : " + dob);           // 2000-06-15

        // Date arithmetic
        LocalDate nextWeek  = today.plusDays(7);
        LocalDate lastMonth = today.minusMonths(1);
        System.out.println("Next week : " + nextWeek);
        System.out.println("Last month: " + lastMonth);

        // Compare dates
        System.out.println(today.isAfter(dob));   // true
        System.out.println(today.isBefore(dob));  // false

        // Format
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(today.format(fmt));    // 15-01-2024

        // Period → difference between dates
        Period age = Period.between(dob, today);
        System.out.println("Age: " + age.getYears() + " years");
    }
}