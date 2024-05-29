package com.techcrack.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import com.techcrack.DSA.ArraysAndBS.*;
import org.junit.jupiter.api.Test;

public class Tester {

    @Test
    public void rotateBinaryTest(){
        RotateBinaryArray rba=new RotateBinaryArray();

        int[][] mat={
                {0,1},
                {1,0}
        };
        int[][] target={
                {1,0},
                {0,1}
        };

        assertTrue(rba.findRotation1(mat,target));

        int[][] mat1={
                {0,1},
                {1,1}
        };
        int[][] target1={
                {1,0},
                {0,1}
        };

        assertFalse(rba.findRotation1(mat1,target1));

        int[][] mat2={
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int[][] target2={
                {1,1,1},
                {0,1,0},
                {0,0,0}
        };

        assertTrue(rba.findRotation1(mat2,target2));
    }

    @Test
    public void UniqueTest(){
        UniqueAdd ua=new UniqueAdd();
        int[] expected1={-2,-1,0,1,2};
        int[] expected2={-2,-1,1,2};

        assertArrayEquals(expected1,ua.sumZero(5));
        assertArrayEquals(expected2,ua.sumZero(4));
    }

    @Test
    public void luckyNumberTest(){
        LuckyNumberMatrix lnm=new LuckyNumberMatrix();

        int[][] actual={
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };
        int[][] actual1={
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };

        int[][] actual2={
                {7,8},
                {1,2}
        };

        System.out.println(lnm.luckyNumbers(actual));
        System.out.println(lnm.luckyNumbers(actual1));
        System.out.println(lnm.luckyNumbers(actual2));
    }

    @Test
    public void maximumSubArray(){
        MaximumSubArray msa=new MaximumSubArray();

        int[] actual={
                -2,1,-3,4,-1,2,1,-5,4
        };
        int[] actual1={
                5,4,-1,7,8
        };
        int[] actual2={
                1
        };
        assertEquals(6,msa.maxSubArray(actual));
        assertEquals(23,msa.maxSubArray(actual1));
        assertEquals(1,msa.maxSubArray(actual2));
    }

    @Test
    public void reshapeTest(){

        ReShapeMatrix rsm=new ReShapeMatrix();
        int[][] actual={
                {1,2},
                {3,4}
        };

        int[][] expected={
                {1,2,3,4}
        };

        assertArrayEquals(actual,rsm.matrixReshape(actual,2,4));
    }

    @Test
    public void plusOneTest(){
        PlusOne po=new PlusOne();

        int[] actual={1,2,3};

        int[] expected={1,2,4};

        assertArrayEquals(expected,po.plusOne1(actual));
    }
    @Test
    public void spiralMatrix3(){
        SpiralMatrix3 sp3=new SpiralMatrix3();
        int[][] expected={{0,0},
                {0,1},
                {0,2},
                {0,3}
        };
        assertArrayEquals(expected,sp3.spiralMatrixIII(1,4,0,0));
    }


    @Test
    public void setmatrixTest(){
        SetMatrixZeros smz=new SetMatrixZeros();

        int[][] actual={
                {1,1,1},
                {1,0,1},
            {1,1,1}
        };

        int[][] expected={
                {1,0,1},
            {0,0,0},
            {1,0,1}
        };

        smz.setZeroes1(actual);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void productArray(){
        ProductArrayItself pai=new ProductArrayItself();

        int[] actual={
                1,2,3,4
        };

        int[] expected={
                24,12,8,6
        };


        assertArrayEquals(expected,pai.productExceptSelf(actual));
    }

    @Test
    public void firstAndLast(){
        FirstAndLastSearch fal=new FirstAndLastSearch();
        int[] actual={5,7,7,8,8,10};

        int[] expected={0,0};

        assertArrayEquals(expected,fal.first(actual,5));
    }


    @Test
    public void jumpGame(){
        int[] actual={2,3,1,1,4};

        int[] actual1={3,2,1,0,4};


        JumpGame jg=new JumpGame();

        assertTrue(jg.canJump(actual));

        assertFalse(jg.canJump(actual1));
    }


    @Test
    public void sortColorTest(){
        SortColors sc=new SortColors();

        int[] actual={2,0,2,1,1,0};

        int[] expected={0,0,1,1,2,2};

        sc.sortColors(actual);

        assertArrayEquals(expected,actual);
    }


    @Test
    public void rob(){
        HouseRobber hr=new HouseRobber();

        int[] actual={
                1,2,3,1
        };

        int[] actual1={
                2,7,9,3,1
        };

        int[] actual2={
                2,1,1,2
        };
        int[] actual4= {
                1, 1, 1
        };
        int[] actual3={1,3,1,3,100};
        assertEquals(2,hr.rob(actual4));
        assertEquals(103,hr.rob(actual3));
        assertEquals(4,hr.rob(actual2));
        assertEquals(4,hr.rob(actual));
        assertEquals(12,hr.rob(actual1));
    }

    @Test
    public void maxValueEquationTest(){
        MaxValueEquation mvr=new MaxValueEquation();

        int[][] actual={
                {1,3},
                {2,0},
                {5,10},
                {6,-10}
        };


        assertEquals(4,mvr.findMaxValueOfEquation(actual,1));
    }

}

