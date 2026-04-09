import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};

        TrainConsistManagementApp.sortBogieNames(bogieNames);

        assertArrayEquals(expected, bogieNames, "Bogie names should be sorted alphabetically.");
    }

    @Test
    void testSort_UnsortedInput() {
        String[] bogieNames = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};

        TrainConsistManagementApp.sortBogieNames(bogieNames);

        assertArrayEquals(expected, bogieNames, "Unsorted names should be rearranged alphabetically.");
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] bogieNames = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};

        TrainConsistManagementApp.sortBogieNames(bogieNames);

        assertArrayEquals(expected, bogieNames, "Already sorted array should remain unchanged.");
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};

        TrainConsistManagementApp.sortBogieNames(bogieNames);

        assertArrayEquals(expected, bogieNames, "Duplicates should be retained and ordered correctly.");
    }

    @Test
    void testSort_SingleElementArray() {
        String[] bogieNames = {"Sleeper"};
        String[] expected = {"Sleeper"};

        TrainConsistManagementApp.sortBogieNames(bogieNames);

        assertArrayEquals(expected, bogieNames, "Single element array should remain unchanged.");
    }
}