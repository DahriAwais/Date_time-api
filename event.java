

import java.time.Duration;
import java.time.LocalDateTime;

public class event{

    public static void main(String[] args) {
        LocalDateTime eventStart = LocalDateTime.of(2024, 4, 28, 10, 0)
        //Example start time
        LocalDateTime eventEnd = LocalDateTime.of(2024, 4, 28, 15, 30)
        //Example end time

        Duration duration = Duration.between(eventStart, eventEnd);

        long hours = duration.toHours();
        long minutes = duration.minusHours(hours).toMinutes();

        System.out.println("Duration: " + hours + " hours and " + minutes + " minutes");
    }
}