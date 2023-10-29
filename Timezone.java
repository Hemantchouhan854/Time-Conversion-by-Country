import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class Timezone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define a list of predefined time zones
        List<String> predefinedTimeZones = Arrays.asList(
                "America/New_York",
                "Europe/London",
                "Asia/Tokyo",
                "Australia/Sydney",
                "America/Los_Angeles",
                "Asia/Kolkata" // Indian time zone
        );

        // Display the available time zones to the user
        System.out.println("Choose a predefined time zone:");
        for (int i = 0; i < predefinedTimeZones.size(); i++) {
            System.out.println((i + 1) + ". " + predefinedTimeZones.get(i));
        }

        // Prompt the user to select a time zone
        System.out.print("Enter the number of the time zone: ");
        int timeZoneChoice = scanner.nextInt();

        // Check if the user's choice is valid
        if (timeZoneChoice < 1 || timeZoneChoice > predefinedTimeZones.size()) {
            System.out.println("Invalid choice. Please select a valid number.");
            scanner.close();
            return;
        }

        // Get the selected time zone
        String selectedTimeZone = predefinedTimeZones.get(timeZoneChoice - 1);

        // Get the current date and time in the selected time zone
        ZoneId targetTimeZone = ZoneId.of(selectedTimeZone);
        ZonedDateTime targetTime = ZonedDateTime.now(targetTimeZone);

        // Display the current time in the selected time zone
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        System.out.println("Current Time in " + selectedTimeZone + ": " + targetTime.format(outputFormatter));

        scanner.close();
    }
}
