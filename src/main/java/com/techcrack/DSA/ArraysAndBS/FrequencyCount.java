package com.techcrack.DSA.ArraysAndBS;

import java.util.Arrays;

public class FrequencyCount {
    public int maxFrequency(int[] nums, int kth) {
        int start = 0;
        int end = nums.length - 1;
        int answer = 1;

        long[] prefixSum = new long[end + 1];

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        //System.out.println(nums.length);

        prefixSum[0] = nums[0];

        for(int k = 1; k < end + 1; k++){
            prefixSum[k] = nums[k] + prefixSum[k - 1];
        }

        System.out.println(Arrays.toString(prefixSum));

        while(start <= end){
            int mid = (start + end) / 2;

            System.out.println(start + " start " + end + " end ");
            System.out.println(prefixSum[mid] + " " + ((mid + 1) * nums[mid]) + " " + nums[mid]  + " " + mid);

            int frequency = countOccurencePossible(mid, nums, kth);

            System.out.println("frequency : " + frequency);

            if(frequency == mid + 1){
                answer = frequency;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return answer;
    }

    private int countOccurencePossible(int target, int[] nums, long operation){

        long targetValue = nums[target--];
        int count = 1;

        while(target >= 0 && operation > 0){
            if(nums[target] + operation >= targetValue){
                count++;
                operation += nums[target];
                operation -= targetValue;
                target--;
            }
            else
                return count;

        }

        return count;
    }
}
