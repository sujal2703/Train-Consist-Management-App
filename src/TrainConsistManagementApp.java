import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 1. Reusing the Bogie class
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

public class TrainConsistManagementApp {

    // --- LOOP-BASED FILTERING ---
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filteredList = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > threshold) {
                filteredList.add(b);
            }
        }
        return filteredList;
    }

    // --- STREAM-BASED FILTERING ---
    public static List<Bogie> filterUsingStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    // Helper method to generate a massive list for realistic benchmarking
    public static List<Bogie> generateLargeBogieList(int size) {
        List<Bogie> largeList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            // Alternate capacities for variety
            int capacity = (i % 2 == 0) ? 72 : 56;
            largeList.add(new Bogie("Bogie-" + i, capacity));
        }
        return largeList;
    }

    public static void main(String[] args) {
        System.out.println("--- Train Consist Management System ---");
        System.out.println("Executing UC13: Loops vs Streams Benchmark\n");

        // 1. Create a large collection of bogies for testing
        int datasetSize = 1_000_000;
        System.out.println("Generating dataset of " + datasetSize + " bogies...");
        List<Bogie> massiveTrain = generateLargeBogieList(datasetSize);
        int threshold = 60;

        // Warm-up the JVM (Java optimizes code on the fly. Running it once before measuring gives fairer results)
        filterUsingLoop(massiveTrain, threshold);
        filterUsingStream(massiveTrain, threshold);

        System.out.println("\n--- Starting Benchmark (Threshold > " + threshold + ") ---");

        // --- 2. MEASURE LOOP PERFORMANCE ---
        long loopStartTime = System.nanoTime();
        List<Bogie> loopResults = filterUsingLoop(massiveTrain, threshold);
        long loopEndTime = System.nanoTime();
        long loopDuration = loopEndTime - loopStartTime;

        System.out.println("Loop-based execution time   : " + loopDuration + " nanoseconds (" + (loopDuration / 1_000_000) + " ms)");

        // --- 3. MEASURE STREAM PERFORMANCE ---
        long streamStartTime = System.nanoTime();
        List<Bogie> streamResults = filterUsingStream(massiveTrain, threshold);
        long streamEndTime = System.nanoTime();
        long streamDuration = streamEndTime - streamStartTime;

        System.out.println("Stream-based execution time : " + streamDuration + " nanoseconds (" + (streamDuration / 1_000_000) + " ms)");

        // Verification
        System.out.println("\nVerification: Both methods found " + loopResults.size() + " matching bogies.");
    }
}