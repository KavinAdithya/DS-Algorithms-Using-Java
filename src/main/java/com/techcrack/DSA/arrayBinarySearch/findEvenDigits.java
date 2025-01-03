package com.techcrack.DSA.arrayBinarySearch;

public class findEvenDigits {
    //An array given we needed to find the even numbers in the given array
    public int findNumbers(int[] nums) {
        int count=0;
        for(int k:nums){
            if(counter(k))
                count++;
        }

        return count;
    }

    //Responsible for counting the digit and return true or false if even or not
    private boolean counter(int n){
        int count=0;

        while(n!=0){
            count++;
            n/=10;
        }

        if(count%2==0)
            return true;
        return false;
    }


    public int findNumbers1(int[] nums){
        return check(nums,0,0);
    }
    private int check(int[] array,int n,int ans){
        if(n<array.length){
            int count=0;
            while(array[n]!=0){
                count++;
                array[n]/=10;
            }
            if(count%2==0)
                ans++;
            return check(array,n+1,ans);
        }
        return ans;
    }
}
