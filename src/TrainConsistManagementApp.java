import java.util.Arrays;

public class TrainConsistManagementApp {

    /**
     * UC20: Optimized search with Fail-Fast State Validation
     */
    public static boolean searchBogieId(String[] bogieIds, String searchKey) {
        // 1. Defend the state: Fail-Fast Validation
        // If the array is null or empty, the train is in an invalid state for searching.
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Cannot perform search: The train consist is empty.");
        }

        // 2. Precondition for Binary Search
        Arrays.sort(bogieIds);

        // 3. Execution logic (Only runs if validation passed)
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM");
        System.out.println("   UC20: Defensive Programming (Fail-Fast)");
        System.out.println("=========================================\n");

        // Scenario 1: Valid Train Consist
        String[] validConsist = {"BG101", "BG205", "BG309"};
        System.out.println("Attempting search on VALID consist...");
        try {
            boolean found = searchBogieId(validConsist, "BG205");
            System.out.println("Search completed successfully. Found: " + found);
        } catch (IllegalStateException e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------------\n");

        // Scenario 2: Invalid/Empty Train Consist
        String[] emptyConsist = {};
        System.out.println("Attempting search on EMPTY consist...");
        try {
            // This will trigger our fail-fast exception
            boolean found = searchBogieId(emptyConsist, "BG101");
            System.out.println("Search completed successfully. Found: " + found);
        } catch (IllegalStateException e) {
            System.out.println("✅ CAUGHT EXCEPTION (System Protected): " + e.getMessage());
        }
    }
}