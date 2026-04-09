import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearchBogieId(bogies, "BG309");
        assertTrue(result, "Search should return true when the bogie ID exists.");
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearchBogieId(bogies, "BG999");
        assertFalse(result, "Search should return false when the bogie ID does not exist.");
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearchBogieId(bogies, "BG101");
        assertTrue(result, "Search should successfully narrow down to the first element.");
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.binarySearchBogieId(bogies, "BG550");
        assertTrue(result, "Search should successfully narrow down to the last element.");
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        boolean result = TrainConsistManagementApp.binarySearchBogieId(bogies, "BG101");
        assertTrue(result, "Search should work properly for arrays with exactly one element.");
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] emptyBogies = {};
        boolean result = TrainConsistManagementApp.binarySearchBogieId(emptyBogies, "BG101");
        assertFalse(result, "Search should safely handle empty arrays and return false.");
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        // Input is out of order. If the method didn't sort it first, binary search would fail.
        String[] unsortedBogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        boolean result = TrainConsistManagementApp.binarySearchBogieId(unsortedBogies, "BG205");
        assertTrue(result, "Method should sort the array internally before executing binary search.");
    }
}