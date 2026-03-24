import java.util.ArrayList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create an ArrayList to hold passenger bogies (CRUD: Create)
        ArrayList<String> passengerBogies = new ArrayList<>();

        System.out.println("--- UC2: Adding Passenger Bogies to Train ---");

        // 2. Add bogies: Sleeper, AC Chair, First Class (add() method)
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion (Read)
        System.out.println("Current Consist: " + passengerBogies);
        System.out.println("Total Bogies: " + passengerBogies.size());

        // 4. Remove one bogie (Example: AC Chair) (Delete)
        System.out.println("\n--- Removing AC Chair Bogie ---");
        passengerBogies.remove("AC Chair");

        // 5. Use contains() to check if 'Sleeper' exists
        System.out.println("Checking for Sleeper bogie...");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("Status: Sleeper bogie is attached to the consist.");
        } else {
            System.out.println("Status: Sleeper bogie not found.");
        }

        // 6. Print final list state
        System.out.println("\nFinal Consist State: " + passengerBogies);
        System.out.println("Final Bogie Count: " + passengerBogies.size());
    }
}