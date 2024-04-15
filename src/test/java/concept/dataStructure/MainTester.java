package concept.dataStructure;

import com.techcrack.DSA.Arrays.ConcatenationTwoArray;
import com.techcrack.DSA.Arrays.RunningSum;
import com.techcrack.DSA.Arrays.SpiralMatrix;
import com.techcrack.DSA.Arrays.ZeroBasedPermutation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
//
//        int[][] actual={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };
//        SortedMatrixSearch sms=new SortedMatrixSearch();
//        int[] expected={0,0};
//        assertArrayEquals(expected,sms.search(actual,1));
        ZeroBasedPermutation zbp=new ZeroBasedPermutation();
        int[] actual={0,2,1,5,3,4};
        int[] expected={0,1,2,4,5,3};
        assertArrayEquals(expected,zbp.array(actual));
    }

    @Test
    public void concatenationTest(){
        int[] actual={1,2,3};
        int[] expected={1,2,3,1,2,3};
        ConcatenationTwoArray cta=new ConcatenationTwoArray();
        assertArrayEquals(expected,cta.concatArray(actual));
    }

    @Test
    public void runningSumTest(){
        RunningSum rs=new RunningSum();

        int[] actual={1,2,3,4,5,6};
        int[] expected={1,3,6,10,15,21};

        assertArrayEquals(expected,rs.runningSum(actual));
    }

    @Test
    public void spiralMatrixTest(){

        int[][] matrix={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        Integer[] expected={1,2,3,6,9,8,7,4,5};
        SpiralMatrix sm=new SpiralMatrix();
        System.out.println(sm.spiralOrder(matrix));
        fail();
    }
}
