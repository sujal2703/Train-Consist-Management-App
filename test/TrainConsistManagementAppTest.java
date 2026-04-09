import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testException_ValidCapacityCreation() {
        // Assert that no exception is thrown when creating a valid bogie
        assertDoesNotThrow(() -> {
            Bogie validBogie = new Bogie("Sleeper", 72);
            assertNotNull(validBogie);
        }, "Valid bogie creation should not throw an exception");
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Assert that creating a bogie with -10 capacity throws the exception
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("First Class", -10);
        }, "Negative capacity should throw InvalidCapacityException");
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Assert that creating a bogie with 0 capacity throws the exception
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("AC Chair", 0);
        }, "Zero capacity should throw InvalidCapacityException");
    }

    @Test
    void testException_ExceptionMessageValidation() {
        // Capture the exception to check its message
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("General", -5);
        });

        // Validate the specific message
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        // Create a valid bogie and ensure its values are mapped correctly
        Bogie bogie = new Bogie("Sleeper", 72);

        assertEquals("Sleeper", bogie.getName());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() {
        // Assert that multiple valid bogies can be instantiated sequentially
        assertDoesNotThrow(() -> {
            Bogie b1 = new Bogie("Sleeper", 72);
            Bogie b2 = new Bogie("AC Chair", 56);
            Bogie b3 = new Bogie("First Class", 24);

            assertNotNull(b1);
            assertNotNull(b2);
            assertNotNull(b3);
        });
    }
}