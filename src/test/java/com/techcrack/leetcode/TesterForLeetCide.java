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

//        FindFirstAndLast fal=new FindFirstAndLast();
//
//        int[] actual={9,11,11,11,11,12,13};
////        int[] ans={5,5};
////        assertArrayEquals(ans,fal.binarySearchNormal(actual,12));
//            InfinityArray ia=new InfinityArray();
//            assertEquals(5,ia.arrayInfinity(actual,12));

//                int[] array={0,5,3,1};
////                MountainPeak mp=new MountainPeak();
////                assertEquals(4,mp.findPeakMountain(array));
//            ArrayMountain am=new ArrayMountain();
//            assertEquals(3,am.findInMountainArray(1,array));
//        int[] nums={2,9,2,2,2};
//        RotatedBinarySearch rbs=new RotatedBinarySearch();
//        assertEquals(1,rbs.findCentralPivot(nums));

    }

    @Test
    public void newTester(){
//        int[] actual={7,2,5,10,8};
//        SubMaxArray sma=new SubMaxArray();
//        assertEquals(4,sma.splitArray(actual,3));

        LongestPalindromeString lps=new LongestPalindromeString();
        String s="cbbd";

        String expected="bb";

        assertEquals(expected,lps.subString(s));
    }
}