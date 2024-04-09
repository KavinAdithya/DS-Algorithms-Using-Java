package com.techcrack.leetcode;


/*
*Array is given like a mountain which means
* values of array initially increases after certain
* point it will be decreasing
* we will know when is sorted we prefer binary
* search to find an element cuz its worst case is lower than
* linear search algorithm
 */
public class MountainPeak {
    public int findPeakMountain(int[] array){
        int start=0;
        int end=array.length-1;

        /*
        *That the array one side is in the first half in ascending and
        * second half is in descending order, and
        * so we will take pointers make the pointers
        * to point the max in ascend and descend
        * it will point to the same index and so return either start or end index
         */

        while(start<end){
            int mid=(start+end)/2;
            if(array[mid]<array[mid+1])
                start=mid+1;
            else
                end=mid;
        }
        return end;
    }
}
