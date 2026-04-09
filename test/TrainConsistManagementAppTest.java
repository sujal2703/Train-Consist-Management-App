import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<Bogie> testBogies;

    @BeforeEach
    void setUp() {
        // Initialize a fresh list before every single test
        testBogies = new ArrayList<>();
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 24));
        testBogies.add(new Bogie("General", 90));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        // Test: Bogies with capacity greater than 70
        List<Bogie> result = TrainConsistManagementApp.filterBogiesByCapacity(testBogies, 70);

        assertEquals(2, result.size(), "Should find 2 bogies (Sleeper and General)");
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        // Test: Threshold is exactly 72. Sleeper is 72, so it should NOT be included (strictly greater than).
        List<Bogie> result = TrainConsistManagementApp.filterBogiesByCapacity(testBogies, 72);

        assertEquals(1, result.size(), "Should only find General (90)");
        assertFalse(result.stream().anyMatch(b -> b.getName().equals("Sleeper")));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        // Test: Threshold is 50. Bogie with 24 (First Class) should be excluded.
        List<Bogie> result = TrainConsistManagementApp.filterBogiesByCapacity(testBogies, 50);

        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 50));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        // Test: Threshold 50. Should match Sleeper(72), AC Chair(56), and General(90).
        List<Bogie> result = TrainConsistManagementApp.filterBogiesByCapacity(testBogies, 50);

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        // Test: Threshold higher than all existing bogies
        List<Bogie> result = TrainConsistManagementApp.filterBogiesByCapacity(testBogies, 100);

        assertTrue(result.isEmpty(), "Resulting list should be empty");
    }

    @Test
    void testFilter_AllBogiesMatching() {
        // Test: Threshold lower than the smallest bogie
        List<Bogie> result = TrainConsistManagementApp.filterBogiesByCapacity(testBogies, 10);

        assertEquals(4, result.size(), "Should include all 4 bogies");
    }

    @Test
    void testFilter_EmptyBogieList() {
        // Test: Filtering a completely empty list
        List<Bogie> emptyList = new ArrayList<>();
        List<Bogie> result = TrainConsistManagementApp.filterBogiesByCapacity(emptyList, 50);

        assertTrue(result.isEmpty(), "Filtering an empty list should return an empty list");
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        // Test: Ensure the original list is not modified by the stream operation
        int originalSize = testBogies.size();
        TrainConsistManagementApp.filterBogiesByCapacity(testBogies, 60);

        assertEquals(originalSize, testBogies.size(), "Original list size should remain exactly the same");
    }
}