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

    private static long[] prefixSum = null;
    private static int[] number = null;

    public int maxFrequency1(int[] nums, int operation) {
        int answer = 1;
        int length = nums.length;

        number = nums;
        prefixSum = new long[length];
        Arrays.sort(nums);

        prefixSum[0] = nums[0];


        for(int k = 1; k < length; k++)
            prefixSum[k] = nums[k] + prefixSum[k - 1];

        for(int k = 0; k < length; k++)
            answer = Math.max(answer, count(k, operation));

        return answer;

    }

    private int count(int index, int operation){
        int res = index;

        int start = 0;
        int end = index;

        while(start <= end){
            int mid = (start + end) / 2;


            long value = prefixSum[index] - prefixSum[mid] + number[mid];
            long newValue = (long)(index - mid + 1) * number[index];

            if(value + operation >= newValue){
                res = mid ;
                end = mid - 1;
            }
            else
                start = mid + 1;

        }

        return index - res + 1;
    }


    public int maxFrequency5(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        int right = 0;

        int max = 1;
        long sum = 0;

        while(right < nums.length){
            sum += nums[right];

            while((long)nums[right] * (right - left + 1) > sum + k){
                sum -= nums[left];
                left++;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }
}
