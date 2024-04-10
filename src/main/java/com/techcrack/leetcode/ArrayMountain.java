package com.techcrack.leetcode;

public class ArrayMountain {

    /*
   *We are Finding the first occurrence of targeted element
   * in an array  using binary search Algorithm
     */

    //Driver Mode For Founding the targeted element index
    public int findInMountainArray(int target, int[] mountainArr) {

        int peak=findPeak(mountainArr);
        int findFirst=binarySearch(mountainArr,0,peak,target,false);

        //System.out.println(peak);
        if(findFirst!=-1)
            return findFirst;
        System.out.println(mountainArr[peak]+" "+findFirst);
        return binarySearch(mountainArr,peak+1,mountainArr.length-1,target,true);
    }

    /*
    *Inorder search for a targeted element here the given array is
    * sorted like first half is ascending and second half is descending order,
    * so  we needed to find the peak (largest element)
    * and we divided the array into virtually
    * first half we will check for the targeted value if found return it as answer
    * or not search in second half if it is not found  her return -1;
     */
    private int findPeak(int[] mountainArray){
        int start=0;
        int end=mountainArray.length-1;

        while(start<end){
            int mid=(start+end)/2;
            if(mountainArray[mid]<mountainArray[mid+1])
                start=mid+1;
            else
                end=mid;
          //  System.out.println(end);
        }

        return end;
    }


    //Applying Binary Search
    private int binarySearch(int[] mountainArray,int start,int end,int target,boolean bool){
        int ans=-1;
        while(start<=end){
            //System.out.println(ans);
            int mid=(start+end)/2;
            if(mountainArray[mid]==target){
                ans=mid;
                end=mid-1;
            }
            else if(mountainArray[mid]<target) {
                if(bool)
                    end=mid-1;
                else
                    start=mid+1;
            }
            else{
                if(bool)
                    start=mid+1;
                else
                    end=mid-1;
            }
            //System.out.println(ans+" "+mid);
        }
        return ans;
    }

}
