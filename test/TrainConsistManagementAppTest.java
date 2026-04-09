import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> train = new ArrayList<>();
        train.add(new GoodsBogie("Cylindrical", "Petroleum"));
        train.add(new GoodsBogie("Cylindrical", "Petroleum"));

        assertTrue(TrainConsistManagementApp.isSafetyCompliant(train),
                "Train should be safe when all cylindrical bogies carry petroleum");
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> train = new ArrayList<>();
        train.add(new GoodsBogie("Cylindrical", "Coal"));

        assertFalse(TrainConsistManagementApp.isSafetyCompliant(train),
                "Train should be unsafe if a cylindrical bogie carries coal");
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> train = new ArrayList<>();
        train.add(new GoodsBogie("Box", "Coal"));
        train.add(new GoodsBogie("Open", "Grain"));
        train.add(new GoodsBogie("Rectangular", "Steel"));

        assertTrue(TrainConsistManagementApp.isSafetyCompliant(train),
                "Train should be safe if non-cylindrical bogies carry various goods");
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> train = new ArrayList<>();
        train.add(new GoodsBogie("Rectangular", "Coal"));
        train.add(new GoodsBogie("Open", "Grain"));
        train.add(new GoodsBogie("Cylindrical", "Petroleum"));
        train.add(new GoodsBogie("Cylindrical", "Chemicals")); // Violation here

        assertFalse(TrainConsistManagementApp.isSafetyCompliant(train),
                "Train should be unsafe if even one bogie violates the safety rule");
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> emptyTrain = new ArrayList<>();

        // In Stream API, allMatch() on an empty stream returns true (vacuous truth)
        assertTrue(TrainConsistManagementApp.isSafetyCompliant(emptyTrain),
                "Empty train has no violations, so it should be considered compliant");
    }
}