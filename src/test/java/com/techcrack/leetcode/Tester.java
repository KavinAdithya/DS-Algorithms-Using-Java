package com.techcrack.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import com.techcrack.DSA.Arrays.RotateBinaryArray;
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
}
