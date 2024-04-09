package com.techcrack.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    @Test
    void mainTester() {

//        SquareRoot sr=new SquareRoot();
//       assertEquals(35614,sr.rootBinarySearch(1268393600));
//        assertEquals(6,sr.rootBinarySearch(36));

//        SmallestCharacter sc=new SmallestCharacter();
//
//        char[] actual={'a','d','e','f','w','x'};
//        char expected='d';
//        char target='b';
//
//        assertEquals(expected,sc.searchForCharacter(actual,target));

        FindFirstAndLast fal=new FindFirstAndLast();

        int[] actual={9,11,11,11,11,12,13};
        int[] ans={5,5};
        assertArrayEquals(ans,fal.binarySearchNormal(actual,12));
    }
}