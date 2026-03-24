import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a HashSet to store unique Bogie IDs
        // HashSet ensures no two bogies have the same ID
        Set<String> bogieIds = new HashSet<>();

        System.out.println("--- UC3: Tracking Unique Bogie IDs (HashSet) ---");

        // 2. Adding unique Bogie IDs
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");

        // 3. Attempting to add a duplicate Bogie ID (BG101)
        System.out.println("Attempting to add duplicate ID: BG101...");
        boolean isAdded = bogieIds.add("BG101");

        if (!isAdded) {
            System.out.println("Alert: Bogie ID BG101 already exists! Duplicate rejected.");
        }

        // 4. Adding another unique ID
        bogieIds.add("BG104");

        // 5. Display the final set of Unique IDs
        System.out.println("\nRegistered Unique Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println("Bogie ID: " + id);
        }

        // 6. Summary
        System.out.println("\nTotal Unique Bogies Registered: " + bogieIds.size());
    }
}