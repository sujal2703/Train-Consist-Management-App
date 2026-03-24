import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a LinkedHashSet to represent the train formation
        // This ensures Uniqueness (Set) + Insertion Order (Linked)
        Set<String> trainFormation = new LinkedHashSet<>();

        System.out.println("--- UC5: Preserving Insertion Order with Uniqueness ---");

        // 2. Attach bogies in a specific sequence
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Initial Formation: " + trainFormation);

        // 3. Attempt to attach a duplicate bogie (Sleeper)
        System.out.println("\nAction: Attempting to attach another 'Sleeper' bogie...");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Result: Duplicate 'Sleeper' rejected! (Business rule enforced)");
        }

        // 4. Attach a new unique bogie
        trainFormation.add("AC Coach");

        // 5. Display the final formation
        // Notice how the order is preserved exactly as they were added
        System.out.println("\n--- Final Train Composition ---");
        int sequence = 1;
        for (String bogie : trainFormation) {
            System.out.println("Position " + sequence + ": " + bogie);
            sequence++;
        }

        System.out.println("\nTotal unique bogies in formation: " + trainFormation.size());
    }
}