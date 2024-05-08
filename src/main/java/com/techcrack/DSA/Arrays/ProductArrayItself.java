package com.techcrack.DSA.Arrays;

public class ProductArrayItself {
    /*
        *Given array we needed to return the array
        * in each index we needed to insert the product of array
        * except the given index element
     */


    public int[] productExceptSelf1(int[] nums) {
        int[] answer=new int[nums.length];

        for(int k=0;k<nums.length;k++){
            answer[k]=fact(nums,k);
        }

        return answer;
    }

    //Fact except the index of element
    private int fact(int[] nums,int index){
        int fact=1;
        for(int k=0;k<nums.length;k++){
            if(index==k)continue;
            else fact*=nums[k];
        }

        return fact;
    }

    public int[] productExceptSelf(int[] nums){

        int[] right=new int[nums.length];
        int[] left=new int[nums.length];

        left[0]=1;

        for(int k=1;k<nums.length;k++){
            left[k]=left[k-1]*nums[k-1];
        }

        right[nums.length-1]=1;
        for(int k=nums.length-2;k>=0;k--){
            right[k]=right[k+1]*nums[k+1];
        }

        for(int k=0;k<nums.length;k++){
            nums[k]=left[k]*right[k];
        }


        return nums;
    }

}
