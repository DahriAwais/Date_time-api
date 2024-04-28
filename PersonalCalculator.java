import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonalCalendar {
    private Map<String, Event> events;

    public PersonalCalendar() {
        this.events = new HashMap<>();
    }

    public void addEvent(String eventName, LocalDateTime dateTime) {
        events.put(eventName, new Event(eventName, dateTime));
    }

    public void editEvent(String eventName, LocalDateTime newDateTime) {
        if (events.containsKey(eventName)) {
            events.get(eventName).setDateTime(newDateTime);
            System.out.println("Event edited successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    public void deleteEvent(String eventName) {
        if (events.containsKey(eventName)) {
            events.remove(eventName);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    public void printEvents() {
        if (events.isEmpty()) {
            System.out.println("No events in the calendar.");
        } else {
            System.out.println("Events in the calendar:");
            for (Event event : events.values()) {
                System.out.println(event);
            }
        }
    }

    public static void main(String[] args) {
        PersonalCalendar calendar = new PersonalCalendar();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n1. Add event\n2. Edit event\n3. Delete event\n4. View events\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
                    LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());
                    calendar.addEvent(eventName, dateTime);
                    break;
                case 2:
                    System.out.print("Enter event name to edit: ");
                    String editEventName = scanner.nextLine();
                    System.out.print("Enter new date and time (yyyy-MM-dd HH:mm): ");
                    LocalDateTime newDateTime = LocalDateTime.parse(scanner.nextLine());
                    calendar.editEvent(editEventName, newDateTime);
                    break;
                case 3:
                    System.out.print("Enter event name to delete: ");
                    String deleteEventName = scanner.nextLine();
                    calendar.deleteEvent(deleteEventName);
                    break;
                case 4:
                    calendar.printEvents();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class Event {
    private String name;
    private LocalDateTime dateTime;

    public Event(String name, LocalDateTime dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return name + " - " + dateTime;
    }
}