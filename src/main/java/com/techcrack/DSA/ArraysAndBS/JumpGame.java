package com.techcrack.DSA.ArraysAndBS;

public class JumpGame {

    /*
        *You are a given array and each element has the maximum jump of element
        * if the element able to move last index return true else return false
     */

    public boolean canJump1(int[] nums) {
        int max=nums[0];
        int move=0;

        for(int k=1;k<nums.length;k++){
            if(nums[k]>max){
                max=nums[k];
                move=-1;
            }
            move++;
            if(move==max){
                if(nums[k]==0)
                    return false;
                max=nums[k];
                move=0;
            }
        }
        return true;
    }

    public boolean canJump(int[] nums){
        int reach=nums[0];

        for(int k=1;k<nums.length;k++){
            if(k>reach)return false;
            reach=(k+nums[k])>reach?(k+nums[k]):reach;
        }
        return true;
    }
}
