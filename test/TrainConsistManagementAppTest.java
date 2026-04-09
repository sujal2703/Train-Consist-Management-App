import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicSorting() {
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        TrainConsistManagementApp.bubbleSortCapacities(capacities);

        assertArrayEquals(expected, capacities, "Array should be sorted in ascending order.");
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72}; // Matches the input

        TrainConsistManagementApp.bubbleSortCapacities(capacities);

        assertArrayEquals(expected, capacities, "Already sorted array should remain unchanged.");
    }

    @Test
    void testSort_DuplicateValues() {
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        TrainConsistManagementApp.bubbleSortCapacities(capacities);

        assertArrayEquals(expected, capacities, "Array with duplicates should be sorted correctly.");
    }

    @Test
    void testSort_SingleElementArray() {
        int[] capacities = {50};
        int[] expected = {50};

        TrainConsistManagementApp.bubbleSortCapacities(capacities);

        assertArrayEquals(expected, capacities, "Single element array should remain unchanged.");
    }

    @Test
    void testSort_AllEqualValues() {
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};

        TrainConsistManagementApp.bubbleSortCapacities(capacities);

        assertArrayEquals(expected, capacities, "Array with all equal values should remain unchanged.");
    }
}