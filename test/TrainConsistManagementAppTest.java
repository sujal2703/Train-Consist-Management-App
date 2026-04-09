import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] emptyBogies = {};

        // Assert that calling search on an empty array throws an IllegalStateException
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            TrainConsistManagementApp.searchBogieId(emptyBogies, "BG101");
        }, "Searching an empty array should throw an IllegalStateException.");

        // Optional: Verify the error message is descriptive
        assertEquals("Cannot perform search: The train consist is empty.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};

        // Assert that the program does NOT throw an exception when data is present
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.searchBogieId(bogies, "BG101");
        }, "Valid array should process without throwing state exceptions.");
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        boolean result = TrainConsistManagementApp.searchBogieId(bogies, "BG205");

        assertTrue(result, "Search should return true when the target bogie exists in a valid array.");
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        boolean result = TrainConsistManagementApp.searchBogieId(bogies, "BG999");

        assertFalse(result, "Search should return false when the target bogie is missing from a valid array.");
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        boolean result = TrainConsistManagementApp.searchBogieId(bogies, "BG101");

        assertTrue(result, "Search should return true for a valid single-element array match.");
    }
}