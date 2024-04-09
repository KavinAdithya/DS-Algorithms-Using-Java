package com.techcrack.leetcode;


/*Assuming the Given Array is Infinity Which means We cannot use the
length variable to find the targeted value index
 */
public class InfinityArray {
  /*
    *Here we are using binary search algorithm
    * first we're finding the start and end untill it satisfy as
    * targeted value lies between the start and end position
    * if not double the size
    * here the time complexity is log n
    * because binary search time complexity is log n and doubling the size is log n.
    * log n+log n =log n
   */
    public int arrayInfinity(int[] array,int target){
        int start=0;
        int end=1;
        while(array[end]<target){
            int newStart=end+1;
            end=end+((end-start+1)*2);
            start=newStart;
        }
        return findElement(array,target,start,end);
    }

    /*
    *binary Search
     */
    private int findElement(int[] array,int target,int start,int end){
        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]==target)
                return mid;
            else if(array[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }

}
