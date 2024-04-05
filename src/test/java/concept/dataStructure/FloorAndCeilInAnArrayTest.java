package concept.dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorAndCeilInAnArrayTest {
    @Test
    void floorOrCeilTest(){
        FloorAndCeilInAnArray fc=new FloorAndCeilInAnArray();
        int[] array={1,2,3,5,7,8,11,34,90,111};
        assertEquals(-1,fc.ceilOrFloor(array,112,2),()->"Thapu Kumaruu");
    }
}