package com.techcrack.DSA.ArrayBinarySearch;

public class SpecialArray {
    public int specialArray(int[] nums) {
        int[] numberArray = new int[1001];

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(int k : nums){
            numberArray[k]++;
            if(minValue > k)
                minValue = k;

            if(maxValue < k)
                maxValue = k;
        }



        for(int k = maxValue; k >= 0; k--){
            if((k+1) != numberArray.length)
                numberArray[k] += numberArray[k+1];
        }
        //System.out.println(Arrays.toString(numberArray));

        int specialValue=-1;

        int start=1;
        int end=maxValue;

        while(start<=end){
            int mid=(start+end)/2;
            if(mid==numberArray[mid]){
                return mid;
            }
            else if(mid>numberArray[mid])
                end=mid-1;
            else
                start=mid+1;
        }


        return specialValue;
    }


    //optimized solution
    public int specialArray1(int[] nums) {
        int maxValue = Integer.MIN_VALUE;

        for(int num : nums){
            if(num > maxValue)
                maxValue = num;
        }

        int start = 1;
        int end = maxValue;

        while(start <= end){
            int mid = (start + end) / 2;


            int greaterMid = checkGreaterMid(nums,mid);

            if(greaterMid == mid)
                return mid;
            else if (greaterMid < mid)
                end = mid - 1;
            else
                start = mid + 1;

        }

        return -1;

    }


    private int checkGreaterMid(int[] nums,int target){
        int count = 0;

        for(int num : nums){
            if(num >= target)
                count++;
        }

        return count;
    }
}
