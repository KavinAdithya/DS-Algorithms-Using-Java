package com.techcrack.leetcode;

public class SmallestCharacter {
    public char searchForCharacter(char[] chArray,char target){
        int start=0;
        int end=chArray.length-1;

        //Using binary Search Algorithm to  find the value which is greater and first value of target
        while(start<=end){

            int mid=(start+end)/2;
            if(chArray[mid]<=target)
                start=mid+1;
            else
                end=mid-1;
        }

        //We are Modulos it because letter wrap around
        return chArray[start%chArray.length];
    }
}
