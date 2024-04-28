
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter date and time (YYYY-MM-DD HH:MM): ");
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.print("Enter source time zone (e.g., UTC): ");
        String sourceTimeZone = scanner.nextLine();

        System.out.print("Enter target time zone (e.g., America/Los_Angeles): ");
        String targetTimeZone = scanner.nextLine();

        ZonedDateTime sourceZonedDateTime = dateTime.atZone(ZoneId.of(sourceTimeZone));
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

        String formattedDateTime = targetZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm zzzz"));
        System.out.println("Converted date and time in " + targetTimeZone + ": " + formattedDateTime);

        scanner.close();
    }
}