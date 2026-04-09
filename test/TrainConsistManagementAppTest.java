import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.linearSearchBogieId(bogies, "BG309");

        assertTrue(result, "Search should return true when the bogie ID exists.");
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.linearSearchBogieId(bogies, "BG999");

        assertFalse(result, "Search should return false when the bogie ID does not exist.");
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.linearSearchBogieId(bogies, "BG101");

        assertTrue(result, "Search should correctly detect a match at the very first position.");
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean result = TrainConsistManagementApp.linearSearchBogieId(bogies, "BG550");

        assertTrue(result, "Search should traverse properly and detect a match at the final position.");
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        boolean result = TrainConsistManagementApp.linearSearchBogieId(bogies, "BG101");

        assertTrue(result, "Search should work correctly for an array containing exactly one element.");
    }
}