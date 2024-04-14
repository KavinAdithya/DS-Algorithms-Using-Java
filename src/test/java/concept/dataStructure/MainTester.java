package concept.dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTester {
    @Test
    void mainTester(){
//        BinarySearch2D bs2=new BinarySearch2D();
//        int[][] actual={
//                {20,28,32},
//                {21,30,35},
//                {25,32,37}
//        };
//
//        int[] expected={-1,-1};
//
//        assertArrayEquals(expected,bs2.search(actual,31));

        int[][] actual={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        SortedMatrixSearch sms=new SortedMatrixSearch();
        int[] expected={0,0};
        assertArrayEquals(expected,sms.search(actual,1));
    }
}
