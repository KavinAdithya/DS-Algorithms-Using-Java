package com.techcrack.DSA.arrayBinarySearch;

public class FirstAndLastSearch {

    /*
        *You are given a non-decreasing array and a target element has been given we needed to find the
        * first and last appearence index of a target element
     */

    public int[] first(int[] array,int target){
        int[] ans=new int[2];

        ans[0]=binarySearch(array,target,true);

        ans[1]=binarySearch(array,target,false);
        return ans;
    }

    private int binarySearch(int[] array,int target,boolean first){
        int ans=-1;

        int start=0;
        int end=array.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]>target)
                end=mid-1;
            else if(array[mid]<target)
                start=mid+1;
            else{
                ans=mid;
                if(first)
                    end=mid-1;
                else start=mid+1;
            }
        }
        return ans;
    }


}
