
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReminderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the date and time for the reminder (yyyy-MM-dd HH:mm):");
        String dateTimeString = scanner.nextLine();

        System.out.println("Enter your reminder message:");
        String reminderMessage = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime reminderDateTime = LocalDateTime.parse(dateTimeString, formatter);

        Timer timer = new Timer();
        timer.schedule(new ReminderTask(reminderMessage), java.sql.Timestamp.valueOf(reminderDateTime).getTime() - System.currentTimeMillis());
    }
}

class ReminderTask extends TimerTask {
    private String message;

    public ReminderTask(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println("Reminder: " + message);
    }
}