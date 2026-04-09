import java.util.ArrayList;
import java.util.List;

// 1. Create the Custom Exception Class
// By extending Exception, this becomes a "Checked Exception"
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// 2. Update the Bogie Class to use the Custom Exception
class Bogie {
    private String name;
    private int capacity;

    // Declare that this constructor might throw an InvalidCapacityException
    public Bogie(String name, int capacity) throws InvalidCapacityException {
        // 3. Fail-Fast Validation
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return String.format("%-15s : %d seats", name, capacity);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("--- Train Consist Management System ---");
        System.out.println("Executing UC14: Custom Exception Validation\n");

        List<Bogie> trainConsist = new ArrayList<>();

        System.out.println("Attempting to assemble train...");

        // Scenario 1: Valid Bogie
        try {
            Bogie sleeper = new Bogie("Sleeper", 72);
            trainConsist.add(sleeper);
            System.out.println("✅ Added: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Failed to add Sleeper: " + e.getMessage());
        }

        // Scenario 2: Invalid Bogie (Zero Capacity)
        try {
            Bogie faultyZero = new Bogie("AC Chair", 0);
            trainConsist.add(faultyZero);
            System.out.println("✅ Added: " + faultyZero);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Failed to add AC Chair: " + e.getMessage());
        }

        // Scenario 3: Invalid Bogie (Negative Capacity)
        try {
            Bogie faultyNegative = new Bogie("First Class", -10);
            trainConsist.add(faultyNegative);
            System.out.println("✅ Added: " + faultyNegative);
        } catch (InvalidCapacityException e) {
            System.out.println("❌ Failed to add First Class: " + e.getMessage());
        }

        System.out.println("\n--- Final Train Consist ---");
        System.out.println("Total Bogies: " + trainConsist.size());
        trainConsist.forEach(System.out::println);
    }
}