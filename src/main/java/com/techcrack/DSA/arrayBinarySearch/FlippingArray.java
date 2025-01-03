package com.techcrack.DSA.arrayBinarySearch;

public class FlippingArray {

    /*
     *Given  a 2D array we needed to reverse the row and invert the elements in the row
     */
    public int[][] flipAndInvertImage(int[][] image) {

        //Iterating the array and each iterate it will return row of matrix
        for(int[] array:image){
            int start=0;
            int end=array.length-1;

            //Rows Are Reversed And inverting this while
            /*
             *we are using while loop
             * we are taking two pointers start and end
             * we are reversing both end values and then inverting it
             */
            while(start<=end) {
                if (array[start] == 0 && array[end] == 0) {
                    array[start] = 1;
                    array[end] = 1;
                } else if (array[start] == 0 && array[end] == 1) {
                    array[end] = 1;
                    array[start] = 0;
                } else if (array[start] == 1 && array[end] == 0) {
                    array[end] = 0;
                    array[start] = 1;
                } else {
                    array[start] = 0;
                    array[end] = 0;
                }
                start++;
                end--;
            }
        }
        return image;
    }
}
