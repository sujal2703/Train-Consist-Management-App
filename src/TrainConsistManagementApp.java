import java.util.Arrays;

public class TrainConsistManagementApp {

    /**
     * UC17: Sorts an array of bogie names alphabetically using Java's built-in optimized sort.
     * Time Complexity: O(n log n)
     */
    public static void sortBogieNames(String[] bogieNames) {
        // Safety check to prevent NullPointerException
        if (bogieNames != null) {
            Arrays.sort(bogieNames);
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM");
        System.out.println("   UC17: Arrays.sort() Implementation");
        System.out.println("=========================================\n");

        // 1. Create an array of bogie type names
        String[] passengerBogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("--- Before Sorting ---");
        // Print the unsorted array using Arrays.toString()
        System.out.println(Arrays.toString(passengerBogies));

        // 2. Execute standard library sort
        sortBogieNames(passengerBogies);

        System.out.println("\n--- After Arrays.sort() ---");
        // Print the sorted array using Arrays.toString()
        System.out.println(Arrays.toString(passengerBogies));
    }
}