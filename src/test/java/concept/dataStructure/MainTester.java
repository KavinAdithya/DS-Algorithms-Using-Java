package concept.dataStructure;

import com.techcrack.DSA.ArraysAndBS.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

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

    }

    @Test
    public void richestCustomerWealth(){
        RichestCustomerWealth rsw=new RichestCustomerWealth();

        int[][] customer={
                {1,2,3},
                {3,4,9},
                {11,2}
        };

        assertEquals(16,rsw.customer(customer));
    }


    @Test
    public void ShuffleArray(){
        ShuffleArray sa=new ShuffleArray();

        int[] array={2,5,1,3,4,7};

        int[] expected={2,3,5,4,1,7};

        assertArrayEquals(expected,sa.array(array,3));
    }

    @Test
    public void candiesTest(){
        Candies candy=new Candies();

        int[] candies={12,1,12};
         List<Boolean> list=candy.kidsWithCandies(candies,10);

         System.out.println(list);
    }

    @Test
    public void spiralMatrix2(){
        SpiralMatrix2 sm=new SpiralMatrix2();

        int[][] matrix=sm.generateMatrix(2);

        for(int[] n:matrix){
            for(int m:n){
                System.out.print(m+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void goodPairTester(){
        GoodPair gp=new GoodPair();
        int[] actual={1,2,3};

        assertEquals(0,gp.numIdenticalPairs(actual));
    }

    @Test
    public void smallerThanYouTester(){
        int[] actual={8,1,2,2,3};
        int[] expected={4,0,1,1,3};

        SmallerThanYou smt=new SmallerThanYou();

        assertArrayEquals(expected,smt.smallerNumbersThanCurrent(actual));
    }

    @Test
    public void targetArrayTest(){
        TargetArray ta=new TargetArray();

        int[] value={1};
        int[] index={0};
        int[] expected={1};

        assertArrayEquals(expected,ta.createTargetArray(value,index));
    }

    @Test
    public void panaGramTest(){
        PanaGram pg=new PanaGram();

        String s="leetcode";

        assertEquals(false,pg.panagram(s));

    }

    @Test
    public void countItemsTest(){
        List<String> list1=new ArrayList<>();
        list1.add("phone");
        list1.add("blue");
        list1.add("pixel");

        List<String> list2=new ArrayList<>();
        list2.add("computer");
        list2.add("silver");
        list2.add("lenovo");

        List<String> list3=new ArrayList<>();
        list3.add("phone");
        list3.add("gold");
        list3.add("iphone");

        List<String> list4=new ArrayList<>();
        list3.add("phone");
        list3.add("gold");
        list3.add("iphone");

        List<List<String>> list=new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        String ruleKey="type";
        String ruleValue="phone";

        CountItemsMatching cim=new CountItemsMatching();
        assertEquals(2,cim.countMatches1(list,ruleKey,ruleValue));


    }


    @Test
    public void highestAltitude(){
        int[] array={-5,1,5,0,-7};
        assertEquals(1,array);
    }

    @Test
    public void flippingArray(){
        FlippingArray fa=new FlippingArray();
        int[][] actual={
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}
        };
        int[][] expected={
                {1,1,0,0},
                {0,1,1,0},
                {0,0,0,1},
                {1,0,1,0}
        };

        assertArrayEquals(expected,fa.flipAndInvertImage(actual));
    }


    @Test
    public void cellsWithOddValue(){
        int[][] actual={
                {0,1},
                {1,1}
        };
        CellsWithOddValue cwv=new CellsWithOddValue();
        assertEquals(6,cwv.oddCells1(2,3,actual));
    }

    @Test
    public void diagonalSumTest(){
        DiagonalSum ds=new DiagonalSum();

        int[][] actual={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        assertEquals(25,ds.diagonalSum(actual));
    }

    @Test
    public void findDigitTest(){
        findEvenDigits fed=new findEvenDigits();

        int[] actual={
                12,345,2,6,7896
        };

        assertEquals(2,fed.findNumbers1(actual));
    }

    @Test
    public void squareMatrix(){
        SquareMatrix sm=new SquareMatrix();
        int[][] actual={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] expected={
                {1,4,7},
                {2,5,8},
                {3,6,9}
        };

        assertArrayEquals(expected,sm.transpose(actual));
    }

    @Test
    public void addToInteger(){
        AddToArrayInteger atai=new AddToArrayInteger();

        int[] actual={
                1,2,0,0
        };

        atai.arrayAdd(actual,805);

        fail("Check It Kavin Again");
    }
}
