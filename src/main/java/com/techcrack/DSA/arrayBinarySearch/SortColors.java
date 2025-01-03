package com.techcrack.DSA.arrayBinarySearch;

public class SortColors {

    /*
        *Given array there are three numbers which are 0-red 1-white 2-blue
        * We needed to arrange the colors in on place on same order

     */
    public void sortColors(int[] nums) {
        int red=0;
        int white=0;
        int blue=0;

        for(int k:nums){
            if(k==0)
                red++;
            else if(k==1)
                white++;
            else
                blue++;
        }


        for(int k=0;k<red||k<white||k<blue;k++){
            if(k<red)
                nums[k]=0;
            if(k<white)
                nums[k+red]=1;
            if(k<blue)
                nums[k+red+white]=2;
        }
    }
}
