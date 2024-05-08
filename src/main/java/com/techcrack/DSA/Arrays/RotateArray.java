package com.techcrack.DSA.Arrays;

public class RotateArray {
    //Given array and k integer represents number elements to be rotated
    //we needed to rotate the array
    public void rotate1(int[] nums, int k) {
        int length=nums.length;
        int index=(length-k);

        int[] ans=new int[length];

        for(int d=0;d<length;d++){
            ans[d]=nums[index%length];
            index++;
        }
        for(int d=0;d<length;d++)
            nums[d]=ans[d];
    }


    //Optimized solution
    public void rotate(int[] nums,int k){
        int n=nums.length;
        k%=n;
        rotateIt(nums,0,n-1);
        rotateIt(nums,0,k-1);
        rotateIt(nums,k,n-1);
    }

    private void rotateIt(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start++]=nums[end];
            nums[end--]=temp;
        }
    }
}
