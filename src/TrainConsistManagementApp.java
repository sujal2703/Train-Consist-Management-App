import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // 1. Create a HashMap to store Bogie-to-Capacity mapping
        // Key: Bogie Name (String), Value: Capacity (Integer)
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        System.out.println("--- UC6: Mapping Bogie to Capacity (HashMap) ---");

        // 2. Use put() to associate bogies with their seating/load capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair Car", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("General", 90);

        // 3. Demonstrate Fast Lookup
        String searchBogie = "AC Chair Car";
        if (bogieCapacityMap.containsKey(searchBogie)) {
            System.out.println("Quick Lookup: " + searchBogie + " has a capacity of " + bogieCapacityMap.get(searchBogie) + " seats.");
        }

        // 4. Iterate over the Map using entrySet()
        System.out.println("\n--- Full Train Capacity Manifest ---");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue() + " units");
        }

        // 5. Total Capacity Calculation (Simple Analytics)
        int totalCapacity = 0;
        for (int capacity : bogieCapacityMap.values()) {
            totalCapacity += capacity;
        }
        System.out.println("\nTotal Potential Train Capacity: " + totalCapacity + " passengers");
    }
}