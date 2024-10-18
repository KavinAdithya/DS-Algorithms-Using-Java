package com.techcrack.DSA.ArrayBinarySearch;

public class ConcatenationTwoArray {
    /*
     *Here array is given we needed to convert array which contains two sub array of given array
     * Here the first solution is get the size of array and multiply its size by 2
     * and iterate and store it
     */
    public int[] getConcatenation(int[] nums) {
        //Array declaration with 2^n size of given array
        int[] array=new int[2*nums.length];

        //using for loop and iterate the array and storing in new array
        //taking a pointer which points the old array index if it reach end of length and initialize it as 0
        int pointer=0;
        for(int k=0;k<array.length;k++){
            if(pointer==nums.length)
                pointer=0;
            array[k]=nums[pointer];
            pointer++;
        }
        return array;
    }

    /*Another best algorithm which using the arraycopy method from System class
     *The method is static
     */
    public int[] array(int[] nums){
        int[] array=new int[nums.length*2];

        System.arraycopy(nums,0,array,0,nums.length);
        System.arraycopy(nums,0,array,nums.length,nums.length);

        return array;
    }

    //here New algorithm which is more effective on space complexity

    public int[] concatArray(int[] nums){
        int[] array=new int[nums.length*2];

        for(int k=0;k<nums.length;k++){
            array[k]=nums[k];
            array[nums.length+k]=nums[k];
        }

        System.gc();
        return array;
    }
}
