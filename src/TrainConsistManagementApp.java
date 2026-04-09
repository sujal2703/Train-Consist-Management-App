import java.util.ArrayList;
import java.util.List;

// 1. Create a GoodsBogie class with type and cargo fields
class GoodsBogie {
    private String type;  // e.g., Cylindrical, Rectangular, Open
    private String cargo; // e.g., Petroleum, Coal, Grain

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return String.format("%-15s : Carrying %s", type, cargo);
    }
}

public class TrainConsistManagementApp {

    /**
     * Checks if the list of goods bogies complies with safety rules.
     * Rule: Cylindrical bogies must ONLY carry Petroleum.
     */
    public static boolean isSafetyCompliant(List<GoodsBogie> goodsBogies) {
        // 2. Convert collection to stream
        return goodsBogies.stream()
                // 3 & 4. Use allMatch() with conditional logic
                .allMatch(bogie -> {
                    if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                        return "Petroleum".equalsIgnoreCase(bogie.getCargo());
                    }
                    // Non-cylindrical bogies are inherently safe in this specific rule check
                    return true;
                });
    }

    public static void main(String[] args) {
        System.out.println("--- Train Consist Management System ---");
        System.out.println("Executing UC12: Safety Compliance Check\n");

        // --- Scenario 1: A Safe Train ---
        List<GoodsBogie> safeTrain = new ArrayList<>();
        safeTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        safeTrain.add(new GoodsBogie("Rectangular", "Coal"));
        safeTrain.add(new GoodsBogie("Open", "Grain"));

        System.out.println("Train 1 Formation:");
        safeTrain.forEach(System.out::println);

        // 5 & 6. Store in boolean and display
        boolean isTrain1Safe = isSafetyCompliant(safeTrain);
        System.out.println("Safety Status: " + (isTrain1Safe ? "✅ COMPLIANT" : "❌ UNSAFE - Rule Violation"));

        System.out.println("\n------------------------------------------------\n");

        // --- Scenario 2: An Unsafe Train ---
        List<GoodsBogie> unsafeTrain = new ArrayList<>();
        unsafeTrain.add(new GoodsBogie("Cylindrical", "Petroleum"));
        unsafeTrain.add(new GoodsBogie("Cylindrical", "Coal")); // VIOLATION!
        unsafeTrain.add(new GoodsBogie("Rectangular", "Steel"));

        System.out.println("Train 2 Formation:");
        unsafeTrain.forEach(System.out::println);

        // 5 & 6. Store in boolean and display
        boolean isTrain2Safe = isSafetyCompliant(unsafeTrain);
        System.out.println("Safety Status: " + (isTrain2Safe ? "✅ COMPLIANT" : "❌ UNSAFE - Rule Violation"));
    }
}