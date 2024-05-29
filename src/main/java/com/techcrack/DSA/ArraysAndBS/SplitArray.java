package com.techcrack.DSA.ArraysAndBS;

public class SplitArray {
    public int splitArray(int[] nums, int k) {
        int start  = 0;
        int end = 0;

        for(int num : nums){
            if(start > num)
                start = num;
            end += num;
        }

        int answer = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            if(isSplitable(nums, mid, k)){
                answer = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return answer;
    }

    private boolean isSplitable(int[] nums, int maximum, int range){
        int count = 1;
        int lastValue = 0;

        for(int num : nums){
            if(num > maximum)
                return false;
            else if(lastValue + num > maximum){
                count++;
                lastValue = num;
            }else
                lastValue += num;
        }

        return count <= range;
    }
}
