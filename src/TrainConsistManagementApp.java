import java.util.Arrays;

public class TrainConsistManagementApp {

    /**
     * UC19: Performs an optimized Binary Search to find a specific Bogie ID.
     * Time Complexity: O(log n) - divides the search space in half each step.
     */
    public static boolean binarySearchBogieId(String[] bogieIds, String searchKey) {
        // Safety checks for null or empty arrays
        if (bogieIds == null || bogieIds.length == 0 || searchKey == null) {
            return false;
        }

        // Precondition: Binary search strictly requires sorted data.
        // Sorting it here ensures we handle unsorted input correctly.
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            // Find the middle index (written this way to prevent integer overflow)
            int mid = low + (high - low) / 2;

            // Compare the search key with the middle element lexicographically
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true; // Match found exactly at the middle!
            } else if (comparison > 0) {
                // The searchKey is alphabetically AFTER the mid element.
                // Ignore the left half and focus on the right half.
                low = mid + 1;
            } else {
                // The searchKey is alphabetically BEFORE the mid element.
                // Ignore the right half and focus on the left half.
                high = mid - 1;
            }
        }

        return false; // Loop exhausted, match not found
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM");
        System.out.println("   UC19: Binary Search (O(log n))");
        System.out.println("=========================================\n");

        // 1. Create an array of bogie IDs (Notice they are completely unsorted)
        String[] consistIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        System.out.println("Train Consist Provided: " + Arrays.toString(consistIds));

        // 2. Search targets
        String target1 = "BG205";
        String target2 = "BG999";

        // 3. Execute Binary Search
        System.out.println("\nSearching for Bogie ID: " + target1 + "...");
        boolean isFound1 = binarySearchBogieId(consistIds, target1);
        System.out.println("Result: " + (isFound1 ? "✅ Bogie Found Quickly" : "❌ Bogie Not Found"));

        System.out.println("\nSearching for Bogie ID: " + target2 + "...");
        boolean isFound2 = binarySearchBogieId(consistIds, target2);
        System.out.println("Result: " + (isFound2 ? "✅ Bogie Found Quickly" : "❌ Bogie Not Found"));
    }
}