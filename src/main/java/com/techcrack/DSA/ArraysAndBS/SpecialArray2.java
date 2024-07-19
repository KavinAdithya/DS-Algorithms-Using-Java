package com.techcrack.DSA.ArraysAndBS;

public class SpecialArray2 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int specialPairs = 0;
        int numsLength = nums.length;
        int queriesLength = queries.length;

        int[] specialArray = new int[numsLength];

        for(int k = 1; k < numsLength; k++){
            if(nums[k - 1] % 2 != nums[k] % 2)
                specialPairs++;
            specialArray[k] = specialPairs;
        }

        boolean[] result = new boolean[queries.length];

        for(int k = 0; k < queriesLength; k++){
            int start = queries[k][0];
            int end = queries[k][1];
            int difference = end - start;
            if(specialArray[start] + difference == specialArray[end])
                result[k] = true;
            else result[k] = false;
        }

        return result;
    }



    static class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int length = nums.length;
            int specialValue = 0;
            int[] prefixSum = new int[length];

            for(int k = 0; k < length - 1; k++){
                if(nums[k] % 2 == nums[k + 1] % 2)
                    specialValue++;
                prefixSum[k + 1] = specialValue;
            }

            //System.out.println(Arrays.toString(prefixSum));

            // for(int  k = 0; k < length - 1; k++)
            //     prefixSum[k + 1] += prefixSum[k];

            //System.out.println(Arrays.toString(prefixSum));

            boolean[] resultList = new boolean[queries.length];

            int index = -1;

            for(int[] query : queries){
                index++;
                if(prefixSum[query[0]] - prefixSum[query[1]] == 0 )
                    resultList[index] = true;
            }


            return resultList;
        }
    }
}
