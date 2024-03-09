package concept.dataStructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LinearSearchTest {
    LinearSearch find=new LinearSearch();
    Integer[] actual={5,43,7,19,3};
    Integer[] expected={3,5,7,19,43};
    @Test
    void findMyPosition() {
        assertEquals(3,find.<Integer>findMyPosition(actual,19));
    }

    @Test
    void binarySearch() {
        assertEquals(4,find.<Integer>binarySearch(actual,3));
    }
}