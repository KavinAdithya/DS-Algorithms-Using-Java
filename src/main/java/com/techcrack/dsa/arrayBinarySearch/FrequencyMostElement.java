package com.techcrack.dsa.arrayBinarySearch;

import java.util.Arrays;

public class FrequencyMostElement {

    public int maxFrequency(int[] num, int operation) {

        int frequencyCount = 1;
        long[] numSum = new long[num.length];

        Arrays.sort(num);

        numSum[0] = num[0];

        for(int k = 1; k < num.length; k++)
            numSum[k] =  numSum[k-1] + num[k];

        System.out.println(numSum[numSum.length - 1]);
        for(int k = num.length - 1; k > 0; k--){
            int count = findFrequency(num, numSum, k, operation);
            if(count > frequencyCount)
                frequencyCount = count;
        }

        return frequencyCount;

    }
    public int maxFrequency1(int[] nums, int k) {
        long countFrequency = 0;
        long sumOfElements = 0 ;
        int i = 0;
        Arrays.sort(nums);

        for(int d = 0; d < nums.length; d++){
            sumOfElements += nums[d];

            while((long)(d - i + 1) * nums[d] > sumOfElements + k){
                sumOfElements -= nums[i];
                i++;
            }
            if((d - i + 1) > countFrequency)
                countFrequency = d - i + 1;
        }

        return (int)countFrequency;
    }
    private int findFrequency(int[] num, long[] numSum, int targetIndex, long operation){
        int target = num[targetIndex];
        int start = 0;
        int end = targetIndex - 1;
        int count = 1;

        while(start <= end){

            int mid = (start + end) / 2;
            long value = numSum[end] - numSum[mid] + num[mid] + operation;
            long expected = (long)(end - mid + 1) * num[targetIndex];
            if(value == expected)
                return count + (end - mid + 1);
            else if(value > expected){
                operation = value - expected;
                count += (end - mid + 1);
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return count;
    }

}
