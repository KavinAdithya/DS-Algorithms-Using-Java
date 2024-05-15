package com.techcrack.DSA.Arrays;

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
