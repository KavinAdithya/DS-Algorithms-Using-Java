package com.techcrack.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import com.techcrack.DSA.Arrays.LuckyNumberMatrix;
import com.techcrack.DSA.Arrays.RotateBinaryArray;
import com.techcrack.DSA.Arrays.UniqueAdd;
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
}
