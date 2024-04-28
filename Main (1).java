import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time in 24-hour format (e.g., '14:23'): ");
        String time24h = scanner.nextLine();
        System.out.println("Time in 12-hour format: " + convertTo12Hour(time24h));
        scanner.close();
    }

    public static String convertTo12Hour(String time24h) {
        String[] parts = time24h.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        String period;

        if (hour < 12) {
            period = "AM";
            if (hour == 0) {
                hour = 12;
            }
        } else {
            period = "PM";
            if (hour != 12) {
                hour -= 12;
            }
        }

        return String.format("%d:%02d %s", hour, minute, period);
    }
}