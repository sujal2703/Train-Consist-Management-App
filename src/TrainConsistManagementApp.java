public class TrainConsistManagementApp {

    /**
     * UC18: Performs a Linear Search to find a specific Bogie ID.
     * Time Complexity: O(n) - traverses sequentially.
     */
    public static boolean linearSearchBogieId(String[] bogieIds, String searchKey) {
        // Safety check for null data
        if (bogieIds == null || searchKey == null) {
            return false;
        }

        // Sequential traversal
        for (int i = 0; i < bogieIds.length; i++) {
            // Equality comparison safely using .equals()
            if (searchKey.equals(bogieIds[i])) {
                return true; // Early termination: Match found!
            }
        }

        return false; // Traversed entire array, match not found
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM");
        System.out.println("   UC18: Linear Search (Bogie ID)");
        System.out.println("=========================================\n");

        // 1. Create an array of bogie IDs
        String[] consistIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        System.out.print("Current Train Consist: ");
        for (String id : consistIds) {
            System.out.print("[" + id + "] ");
        }
        System.out.println("\n");

        // 2. Accept a bogie ID to search (Simulating user input)
        String searchKey1 = "BG309";
        String searchKey2 = "BG999";

        // 3. Search and print results
        System.out.println("Searching for Bogie ID: " + searchKey1 + "...");
        boolean isFound1 = linearSearchBogieId(consistIds, searchKey1);
        System.out.println("Result: " + (isFound1 ? "✅ Bogie Exists" : "❌ Bogie Not Found"));

        System.out.println("\nSearching for Bogie ID: " + searchKey2 + "...");
        boolean isFound2 = linearSearchBogieId(consistIds, searchKey2);
        System.out.println("Result: " + (isFound2 ? "✅ Bogie Exists" : "❌ Bogie Not Found"));
    }
}