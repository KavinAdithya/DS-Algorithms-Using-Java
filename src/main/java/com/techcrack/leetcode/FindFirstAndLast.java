package com.techcrack.leetcode;

public class FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] ans={-1,-1};

        //Searching for first and Last Index
        //using separate binary search for first and last occurence
        ans[0]=binarySearch(nums,target,true);

        //Last Occurence
        ans[1]=binarySearch(nums,target,false);

        return ans;
    }


    //Actual binary search
    private int binarySearch(int[] nums,int target,boolean firstSearch){

        int ans=-1;
        int front=0;
        int end=nums.length-1;

        while(front<=end){
            int mid=(front+end)/2;

            if(nums[mid]>target)
                end=mid-1;
            else if(nums[mid]<target)
                front=mid+1;
            else{
                ans=mid;
                if(firstSearch)
                    end=mid-1;
                else
                    front=mid+1;
            }
        }

        return ans;
    }


    public int[] binarySearchNormal(int[] nums,int target){
        int[] ans={-1,-1};

        int front=0;

        int end=nums.length-1;

        boolean first=false;
        boolean last=false;
        while(front<=end){
            if(!first){
                if(nums[front]==target){
                    first=true;
                    ans[0]=front;
                }
                else
                    front++;
            }
            if(!last){
                if(nums[end]==target){
                    last=true;
                    ans[1]=end;
                }
                else
                    end--;
            }
            if(last&&first)
                break;
        }

        return ans;
    }

}
