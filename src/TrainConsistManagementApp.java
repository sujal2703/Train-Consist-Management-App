import java.util.Arrays;

public class TrainConsistManagementApp {

    /**
     * UC16: Sorts an array of bogie capacities using the Bubble Sort algorithm.
     * Time Complexity: O(n²) in the worst case.
     */
    public static void bubbleSortCapacities(int[] capacities) {
        // Safety check for null or empty/single-element arrays
        if (capacities == null || capacities.length <= 1) {
            return;
        }

        int n = capacities.length;
        boolean swapped;

        // Outer loop for multiple passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for adjacent comparisons
            for (int j = 0; j < n - i - 1; j++) {

                // If the left element is greater than the right element, swap them
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true; // Mark that a swap occurred
                }
            }

            // Optimization: If no elements were swapped in the inner loop,
            // the array is already sorted, and we can break early.
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM");
        System.out.println("   UC16: Manual Bubble Sort");
        System.out.println("=========================================\n");

        int[] passengerCapacities = {72, 56, 24, 70, 60};

        System.out.println("--- Before Sorting ---");
        System.out.println(Arrays.toString(passengerCapacities));

        // Execute the manual sort
        bubbleSortCapacities(passengerCapacities);

        System.out.println("\n--- After Bubble Sort ---");
        System.out.println(Arrays.toString(passengerCapacities));
    }
}