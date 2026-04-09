import java.util.ArrayList;
import java.util.List;

// 1. Create a Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// 2. Updated GoodsBogie Class for Dynamic Assignment
class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type) {
        this.type = type;
        this.cargo = "Empty"; // Default state
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    // 3. Throw the exception when a safety rule is violated
    public void assignCargo(String newCargo) {
        if ("Rectangular".equalsIgnoreCase(this.type) && "Petroleum".equalsIgnoreCase(newCargo)) {
            throw new CargoSafetyException("Unsafe Assignment: Rectangular bogies cannot carry Petroleum due to leak hazards!");
        }
        this.cargo = newCargo;
    }

    @Override
    public String toString() {
        return String.format("%-15s : Carrying %s", type, cargo);
    }
}

public class TrainConsistManagementApp {

    // 4. Catch the exception and execute the finally block
    public static boolean safelyAssignCargo(GoodsBogie bogie, String cargoToAssign) {
        boolean isAssigned = false;

        System.out.println("\nAttempting to assign [" + cargoToAssign + "] to [" + bogie.getType() + "] bogie...");

        try {
            // This line might throw the runtime exception
            bogie.assignCargo(cargoToAssign);
            System.out.println("✅ SUCCESS: Cargo safely loaded.");
            isAssigned = true;

        } catch (CargoSafetyException e) {
            // Handle the error gracefully without crashing
            System.out.println("❌ ERROR CAUGHT: " + e.getMessage());
            isAssigned = false;

        } finally {
            // 5. This always runs, regardless of success or failure
            System.out.println("🔄 [SYSTEM AUDIT] Assignment transaction closed for bogie type: " + bogie.getType());
        }

        return isAssigned;
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM");
        System.out.println("   UC15: Runtime Error Handling");
        System.out.println("=========================================");

        List<GoodsBogie> train = new ArrayList<>();
        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        GoodsBogie bogie3 = new GoodsBogie("Open");

        train.add(bogie1);
        train.add(bogie2);
        train.add(bogie3);

        // Scenario 1: Safe Assignment
        safelyAssignCargo(bogie1, "Petroleum");

        // Scenario 2: Unsafe Assignment (Will trigger Catch block)
        safelyAssignCargo(bogie2, "Petroleum");

        // Scenario 3: Another Safe Assignment (Proves app didn't crash)
        safelyAssignCargo(bogie3, "Coal");

        System.out.println("\n--- Final Train Formation ---");
        train.forEach(System.out::println);
    }
}