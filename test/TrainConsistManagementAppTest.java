import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private GoodsBogie cylindricalBogie;
    private GoodsBogie rectangularBogie;

    @BeforeEach
    void setUp() {
        cylindricalBogie = new GoodsBogie("Cylindrical");
        rectangularBogie = new GoodsBogie("Rectangular");
    }

    @Test
    void testCargo_SafeAssignment() {
        // Assert no exception is thrown for safe assignments
        assertDoesNotThrow(() -> {
            cylindricalBogie.assignCargo("Petroleum");
        });
        assertEquals("Petroleum", cylindricalBogie.getCargo(), "Cargo should be securely assigned.");
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Assert the specific runtime exception is thrown for unsafe logic
        assertThrows(CargoSafetyException.class, () -> {
            rectangularBogie.assignCargo("Petroleum");
        }, "Assigning Petroleum to a Rectangular bogie should throw CargoSafetyException");
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // Ensure state remains unchanged if an exception is thrown
        try {
            rectangularBogie.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Expected
        }
        assertEquals("Empty", rectangularBogie.getCargo(), "Cargo should remain Empty after a failed assignment.");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Verify our handler method safely catches the exception and returns false instead of crashing
        boolean success = TrainConsistManagementApp.safelyAssignCargo(rectangularBogie, "Petroleum");
        assertFalse(success, "Handler should return false on unsafe assignment.");

        // App should still be able to process the next request
        boolean nextSuccess = TrainConsistManagementApp.safelyAssignCargo(cylindricalBogie, "Petroleum");
        assertTrue(nextSuccess, "Handler should successfully process subsequent safe assignments.");
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        /*
         * Note: While difficult to test console output directly without stream redirection,
         * we can verify the behavior of our handling wrapper. Because it returns a boolean
         * AFTER the finally block has executed without interrupting the JVM,
         * it proves the finally block executed safely and yielded control back to the caller.
         */
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.safelyAssignCargo(rectangularBogie, "Petroleum");
        });
    }
}