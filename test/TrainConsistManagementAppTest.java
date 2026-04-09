import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private List<Bogie> smallDataset;

    @BeforeEach
    void setUp() {
        smallDataset = new ArrayList<>();
        smallDataset.add(new Bogie("Sleeper", 72));
        smallDataset.add(new Bogie("AC Chair", 56));
        smallDataset.add(new Bogie("First Class", 24));
        smallDataset.add(new Bogie("General", 90));
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = TrainConsistManagementApp.filterUsingLoop(smallDataset, 60);

        assertEquals(2, result.size(), "Should only find Sleeper and General");
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60),
                "All items in result should have capacity > 60");
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = TrainConsistManagementApp.filterUsingStream(smallDataset, 60);

        assertEquals(2, result.size(), "Should only find Sleeper and General");
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60),
                "All items in result should have capacity > 60");
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = TrainConsistManagementApp.filterUsingLoop(smallDataset, 60);
        List<Bogie> streamResult = TrainConsistManagementApp.filterUsingStream(smallDataset, 60);

        assertEquals(loopResult.size(), streamResult.size(),
                "Both methods should return the exact same number of bogies");
    }

    @Test
    void testExecutionTimeMeasurement() {
        // Measure Loop
        long loopStart = System.nanoTime();
        TrainConsistManagementApp.filterUsingLoop(smallDataset, 60);
        long loopEnd = System.nanoTime();
        long loopElapsed = loopEnd - loopStart;

        // Measure Stream
        long streamStart = System.nanoTime();
        TrainConsistManagementApp.filterUsingStream(smallDataset, 60);
        long streamEnd = System.nanoTime();
        long streamElapsed = streamEnd - streamStart;

        assertTrue(loopElapsed > 0, "Loop elapsed time should be greater than 0 nanoseconds");
        assertTrue(streamElapsed > 0, "Stream elapsed time should be greater than 0 nanoseconds");
    }

    @Test
    void testLargeDatasetProcessing() {
        // Generate 50,000 items
        List<Bogie> largeList = TrainConsistManagementApp.generateLargeBogieList(50000);

        // Ensure filtering completes successfully and returns the expected subset
        List<Bogie> result = TrainConsistManagementApp.filterUsingStream(largeList, 60);

        // Since our generate method alternates 72 and 56, exactly half should be > 60
        assertEquals(25000, result.size());
    }
}