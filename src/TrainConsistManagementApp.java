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
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// --- BOGIE CLASS ---
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
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

// --- MAIN APPLICATION CLASS ---
public class TrainConsistManagementApp {

 feature/UC15
    // 4. Catch the exception and execute the finally block
    public static boolean safelyAssignCargo(GoodsBogie bogie, String cargoToAssign) {
        boolean isAssigned = false;

 feature/UC14
    public static void main(String[] args) {
        System.out.println("--- Train Consist Management System ---");
        System.out.println("Executing UC14: Custom Exception Validation\n");

        List<Bogie> trainConsist = new ArrayList<>();


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

feature/UC15
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

        System.out.println("\n--- Final Train Consist ---");
        System.out.println("Total Bogies: " + trainConsist.size());
        trainConsist.forEach(System.out::println);

    // --- UC11: Regex Validation Setup ---
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";
    private static final Pattern TRAIN_ID_PATTERN = Pattern.compile(TRAIN_ID_REGEX);
    private static final Pattern CARGO_CODE_PATTERN = Pattern.compile(CARGO_CODE_REGEX);

    public static boolean isValidTrainId(String trainId) {
        if (trainId == null || trainId.isEmpty()) return false;
        return TRAIN_ID_PATTERN.matcher(trainId).matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) return false;
        return CARGO_CODE_PATTERN.matcher(cargoCode).matches();
    }

    // --- UC8: Filter Logic ---
    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // --- UC9: Grouping Logic ---
    public static Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    // --- UC10: Reduce Logic ---
    public static int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    // --- MAIN EXECUTION METHOD ---
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM");
        System.out.println("=========================================\n");

        // --- 1. Test Regex Validation (UC11) ---
        System.out.println("--- 1. Input Validation ---");
        String trainId = "TRN-1234";
        System.out.println("Validating Train ID '" + trainId + "': " +
                (isValidTrainId(trainId) ? "ACCEPTED" : "REJECTED"));

        String badCargo = "PET123";
        System.out.println("Validating Cargo Code '" + badCargo + "': " +
                (isValidCargoCode(badCargo) ? "ACCEPTED" : "REJECTED"));
        System.out.println();

        // --- Create Bogie Data ---
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        // --- 2. Test Sorting (UC7) ---
        System.out.println("--- 2. Bogies Sorted By Capacity ---");
        List<Bogie> sortedBogies = new ArrayList<>(passengerBogies); // Copy to keep original intact
        sortedBogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        sortedBogies.forEach(System.out::println);
        System.out.println();

        // --- 3. Test Filtering (UC8) ---
        int filterThreshold = 60;
        System.out.println("--- 3. Bogies with Capacity > " + filterThreshold + " ---");
        List<Bogie> highCapacityBogies = filterBogiesByCapacity(passengerBogies, filterThreshold);
        highCapacityBogies.forEach(System.out::println);
        System.out.println();

        // --- 4. Test Grouping (UC9) ---
        System.out.println("--- 4. Bogies Grouped By Type ---");
        Map<String, List<Bogie>> groupedBogies = groupBogiesByType(passengerBogies);
        groupedBogies.forEach((category, bogieList) -> {
            System.out.println(category + " (Count: " + bogieList.size() + ")");
        });
        System.out.println();

        // --- 5. Test Reduce/Total (UC10) ---
        System.out.println("--- 5. Total Train Capacity Analytics ---");
        int totalSeats = calculateTotalSeats(passengerBogies);
        System.out.println("Total Seating Capacity: " + totalSeats + " seats");
        System.out.println("=========================================");
main

    }
}