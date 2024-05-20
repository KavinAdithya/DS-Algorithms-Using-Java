package com.techcrack.DSA.Arrays;

import java.util.Arrays;
public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int aliceCandies=0;
        for(int k:aliceSizes)
            aliceCandies+=k;

        int bobCandies=0;
        boolean[] result=new boolean[100001];
        for(int k=0;k<bobSizes.length;k++){
            result[bobSizes[k]]=true;
            bobCandies+=bobSizes[k];
        }
        int diff=(aliceCandies-bobCandies)/2;
        for(int k=0;k<aliceSizes.length;k++){

            int searchElement=aliceSizes[k]-diff;
            if(searchElement>=0&&searchElement<=100001&&result[searchElement])
                return new int[]{aliceSizes[k],searchElement};
        }
        return null;
    }
}

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int candiesAlice = countCandies(aliceSizes);
        int candiesBob = countCandies(bobSizes);
        int sameCandies = (candiesAlice - candiesBob) / 2;

        Arrays.sort(aliceSizes);

        for(int bobCandy : bobSizes){
            int aliceCandy = binarySearch(aliceSizes, bobCandy + sameCandies);
            if(aliceCandy != -1)
                return new int[]{aliceCandy,bobCandy};
        }
        return new int[]{-1,-1};
    }

    private int countCandies(int[] candies){
        int candie = 0;
        for(int candy : candies)
            candie += candy;
        return candie;
    }

    private int binarySearch(int[] candies, int targetCandy){
        int start = 0;
        int end = candies.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(candies[mid] == targetCandy)
                return targetCandy;
            else if(candies[mid] > targetCandy)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }
}