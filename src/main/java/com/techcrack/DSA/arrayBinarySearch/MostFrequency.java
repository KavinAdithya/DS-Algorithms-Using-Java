package com.techcrack.DSA.arrayBinarySearch;

import java.util.Arrays;

public class MostFrequency {

    //Brute Force
    public int maxFrequency1(int[] nums, int operations) {
        int counter = 1;
        Arrays.sort(nums);

        for(int k = nums.length - 1; k >= 0; k--){
            int operation = operations;
            int count = 1;

            int v = k - 1;

            while(v >= 0 && operation != 0){
                if(nums[v] + operation >= nums[k]){
                    operation -= nums[k] - nums[v];
                    count++;
                }else
                    operation = 0;
                v--;
            }

            if(count > counter)
                counter = count;
        }

        return counter;
    }


    //Binary Search
    public int maxFrequency(int[] nums, int operation) {
        long[] numSum = new long[nums.length];

        Arrays.sort(nums);

        numSum[0] = nums[0];

        for(int k = 1; k < nums.length; k++)
            numSum[k] = numSum[k - 1] + nums[k];

        int answer = 1;

        for(int k = nums.length - 1; k > 0; k--){
            int count = findCount(numSum, nums, operation, k);

            if(count > answer)
                answer = count;
        }

        return answer;
    }

    private int findCount(long[] numSum, int[] sum, int operation, int index){
        int start = 0;
        int end = index - 1;
        int count = 1;

        while(start <= end){
            int mid = (start + end) / 2;

            long expected = (long)(end - mid + 1) * sum[index];
            long actual = numSum[end] - numSum[mid] + sum[mid] + operation;

            if(expected == actual)
                return count + (end - mid + 1);
            else if(expected > actual)
                start = mid + 1;
            else{
                operation = (int)(actual - expected);
                count += (end - mid + 1);
                end = mid - 1;
            }

        }

        return count;
    }

    //Sorting And Sliding Window
    public int maxFrequency2(int[] nums, int k) {
        int leftPointer = 0;
        int rightPointer = 0;
        int sumOf = 0;
        int count = 0;

        Arrays.sort(nums);

        while(rightPointer < nums.length){
            sumOf += nums[rightPointer];

            while( (long)(rightPointer - leftPointer + 1) * nums[rightPointer] > sumOf + k){
                sumOf -= nums[leftPointer];
                leftPointer++;
            }

            if((rightPointer - leftPointer + 1) > count)
                count = rightPointer - leftPointer + 1;

            rightPointer++;
        }

        return count;
    }
}
