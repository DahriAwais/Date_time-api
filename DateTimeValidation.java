import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateTimeValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define the date and time format expected from the user
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        boolean isValidInput = false;
        LocalDateTime userInputDateTime = null;

        // Prompt the user until valid input is provided
        while (!isValidInput) {
            try {
                System.out.println("Enter a date and time in the format yyyy-MM-dd HH:mm:");
                String userInput = scanner.nextLine();

                // Parse the user input into a LocalDateTime object
                userInputDateTime = LocalDateTime.parse(userInput, formatter);

                // Check if the parsed date is in the future
                LocalDateTime currentDateTime = LocalDateTime.now();
                if (userInputDateTime.isAfter(currentDateTime)) {
                    isValidInput = true;
                } else {
                    System.out.println("Please enter a date and time in the future.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date/time format. Please enter again.");
            }
        }

        System.out.println("Valid date and time: " + userInputDateTime);
    }
}