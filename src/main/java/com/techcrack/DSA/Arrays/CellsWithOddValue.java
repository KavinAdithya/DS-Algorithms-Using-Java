package com.techcrack.DSA.Arrays;

import java.util.Arrays;

public class CellsWithOddValue {
    /*first row and column size has been given
     *And initialized with 0s
     * And another 2d array has been given
     * each row in this array increment will take part based on its value
     * There is constraint row size is 2
     * we needed to count the odd numbers present in array  after all the process
     */

    public int oddCells(int m, int n, int[][] indices) {
        int[][] array=new int[m][n];
        int odd=0;
        //System.out.println(Arrays.toString(array[0]));
        //System.out.println(Arrays.toString(array[1]));
        for(int[] indicator:indices){
            int row1=indicator[0];
            int column1=0;
            int column2=indicator[1];
            int row=0;
            for(int k=0;k<n||k<m;k++){
                if(row<m){
                    array[row][column2]++;
                    if(array[row][column2]%2==0)
                        odd--;
                    else
                        odd++;
                }
                if(column1<n){
                    array[row1][column1]++;
                    if(array[row1][column1]%2==0)
                        odd--;
                    else
                        odd++;
                }
                column1++;
                row++;
                System.out.println(Arrays.toString(array[0]));
                System.out.println(Arrays.toString(array[1]));
            }

        }
        return odd;
    }
}
