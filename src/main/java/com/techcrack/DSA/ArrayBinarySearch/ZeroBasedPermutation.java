package com.techcrack.DSA.ArrayBinarySearch;

//Given array is needed to swap the values without using third array
//we are Adding the existing value into new value'
//finally removing the unwanted value
public class ZeroBasedPermutation {
    /*
     * Zero based permutation means it indicates the value is begins with 0 and end is in N
     * Which is sequence and here it is not allowed of duplicates(only distinct values)
     * we can iterate and store it on another array but its consume huge memory
     */
    public int[] buildArray(int[] ints) {
        //New array object creation
        int[] ans=new int[ints.length];

        //Iterating the ints array and storing in new array
        for(int k=0;k<ints.length;k++){
            ans[k]=ints[ints[k]];
        }
        return ans;
    }


    /*
     * Here We are using another algorithm because the existing algorithm
     * not efficient on compared on space complexity
     * And we Are Moving towards to use another algorithm
     */

    public int[] arrayBuild(int[] nums){
        //Array length
        int length=nums.length;
        //Its not good algorithm in the case of time complexity
        //getting the new value and multiply it by length of array and
        //sum the old value.
        //Here the new value is multiply by length and old is stored on sum the old value with new value
        //Assume we have index 0 as 5 index 5 as 3
        //we needed to store the 3 on index 0 and loose the old value
        //And so we are multiply it by length and sum it Here we are assuming the length is 6
        //6*3=18<- new value old value 5 and so 18+5=23 to get old value 23%6=5 for new value 23/6=3
        for(int k=0;k<length;k++){
            nums[k]=nums[k]+(length*(nums[nums[k]]%length));
        }

        //We are now removing the old value by dividing with its length
        for(int k=0;k<length;k++){
            nums[k]=nums[k]/length;
        }
        return nums;
    }


    /*
     *Another great logic using recursion
     * let we see that algorithm
     */

    public int[] array(int[] nums){
        //Invoking the method permutation
        permutation(nums,0);

        return nums;
    }

    //Recursively changing its value
    private void permutation(int[] array,int end){
        if(end<array.length){
            int next=array[end];
            int res=array[next];
            permutation(array,end+1);
            array[end]=res;
        }
    }
}
