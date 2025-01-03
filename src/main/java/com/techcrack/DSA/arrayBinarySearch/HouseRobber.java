package com.techcrack.DSA.arrayBinarySearch;

public class HouseRobber {

    //Your robber you needed to rob money in a street of houses
    //each adjacent houses has security alarm it will invoke if robber happens two houses
    //How can rob the maximum money
//    public int rob(int[] nums) {
//        int max=findTheHouses(nums,0);
//        int max1=0;
//        if(nums.length>1)
//            max1=findTheHouses(nums,1);
//
//        System.out.println(max+" "+max1);
//        return max>max1?max:max1;
//    }
//
////    private int findTheHouses(int[] nums,int start){
////        int ans=nums[start];
////        boolean firstSearch=false;
////        boolean front=false;
////        for(int k=start+2;k<nums.length;k++){
////            if (firstSearch){
////
////                if(nums[k-1]>nums[k]) {
////                    ans += nums[k - 1];
////                    front=true;
////
////                }
////                else {
////                    ans += nums[k];
////                    front = false;
////                }
////                firstSearch=false;
////            }
////            else {
////
////                firstSearch = true;
////                if ((k + 1) == nums.length&&front)
////                    ans += nums[k];
////            }
////        }
////
////        return ans;
////    }
//
//    private int findTheHouses(int[] array,int start){
//        int max=array[start];
//        start+=2;
//
//        int n=array.length;
//        while(start<n){
//            if((start+1)==n)
//                max+=array[start];
//            else if(array[start]<array[start+1]){
//                max+=array[++start];
//            }
//            else
//                max+=array[start];
//            start+=2;
//        }
//
//        return max;
//    }


    public int rob(int[] nums){
        if(nums.length<=1)
            return nums[0];
        int max=0;
        int[] array=new int[nums.length];
        array[0]=nums[0];

        array[1]=nums[0]>nums[1]?nums[0]:nums[1];

        for(int k=2;k<(nums.length);k++){
            array[k]=array[k-1]>(array[k-2]+nums[k])?array[k-1]:(array[k-2]+nums[k]);
        }


        return array[nums.length-1];
    }
}
