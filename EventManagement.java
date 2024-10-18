import java.util.ArrayList;
import java.util.Scanner;

// Event class to store event details
class Event {
    private String eventName;
    private String eventDate;
    private String eventLocation;

    public Event(String eventName, String eventDate, String eventLocation) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
    }

    public String getEventName() {
        return eventName;

    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    @Override
    public String toString() {
        return "Event Name: " + eventName + "\nDate: " + eventDate + "\nLocation: " + eventLocation;
    }
}

// Main class for Event Management
public class EventManagement {
    private static ArrayList<Event> events = new ArrayList<>();

    // Method to add a new event
    public static void addEvent(String name, String date, String location) {
        Event newEvent = new Event(name, date, location);
        events.add(newEvent);
        System.out.println("Event added successfully!\n");
    }

    // Method to display all events
    public static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events to display.\n");
        } else {
            for (int i = 0; i < events.size(); i++) {
                System.out.println("Event " + (i + 1) + ":");
                System.out.println(events.get(i).toString() + "\n");
            }
        }
    }

    // Method to delete an event by its index
    public static void deleteEvent(int index) {
        if (index > 0 && index <= events.size()) {
            events.remove(index - 1);
            System.out.println("Event deleted successfully!\n");
        } else {
            System.out.println("Invalid event number!\n");
        }
    }

    // Main method for the console menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Event Management System:");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Delete Event");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter event date (DD-MM-YYYY): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String location = scanner.nextLine();
                    addEvent(name, date, location);
                    break;

                case 2:
                    viewEvents();
                    break;

                case 3:
                    System.out.print("Enter event number to delete: ");
                    int index = scanner.nextInt();
                    deleteEvent(index);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        } while (choice != 4);

        scanner.close();
    }
}
    

