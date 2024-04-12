package com.techcrack.leetcode;

public class RotatedBinarySearch {


    /*
    *Driver Mode For Searching target element which array is rotated and
    * sorted array where finding the index of targeted element using binary search
     */
    public int binarySearch(int[] nums,int target){

        int pivot=findPivot(nums);
        System.out.println(pivot);
        if(nums[pivot]==target)
            return pivot;
        else if(pivot ==-1)
            return search(nums,0,nums.length-1,target);
        else if(nums[0]<=target)
            return search(nums,0,pivot,target);
        return search(nums,pivot+1,nums.length-1,target);
    }

    /*
    *We know that its a rotated array
    * So we find the maximum element in a array as a pivot,
    * and we will apply binary search and found the index..
    * Here this  method is responsible for finding the pivot element and
    * return index of to its calling method
     */

    private int findPivot(int[] nums){
        int start=0;
        int end=nums.length-1;

        while(start<end){
            int mid=(start+end)/2;
            if( mid<nums.length&&nums[mid]>nums[mid+1])
                return mid;
            else if(mid>0&&nums[mid]<nums[mid-1])
                return mid-1;
             else if(nums[start]<nums[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }


    /*
    *Actual Implementation of binary search finding the targeted element
    * the array will be in ascending order though its a rotated array
    * based on pivot the array has been slashed into sorted array
    * here we needed to apply binary search and find index of targeted element
     */

    private int search(int[] nums,int start,int end,int target){

        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                 start=mid+1;
            else
                end=mid-1;
        }

        return -1;
    }

    public int findCentralPivot(int[] nums){
        int first=0;
        int last=nums.length-1;

        while(first<last){

            int mid=(first+last)/2;

            if(mid<nums.length&&nums[mid]>nums[mid+1])
                return mid;
            else if(mid>0&&nums[mid]<nums[mid-1])
                return mid-1;
            else if(nums[mid]>nums[first])
                first=mid+1;
            else
                last=mid-1;
        }

        return -1;
    }
}
