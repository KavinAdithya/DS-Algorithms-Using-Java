package com.techcrack.dsa.arrayBinarySearch;

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
                if(row<m)
                    array[row][column2]++;
                if(column1<n)
                    array[row1][column1]++;
                column1++;
                row++;
                System.out.println(Arrays.toString(array[0]));
                System.out.println(Arrays.toString(array[1]));
            }

        }
        for(int[] k:array){
            for(int j:k){
                if(j%2!=0)
                    odd++;
                else
                    odd--;
            }
        }
        return odd;
    }

    public int oddCells1(int m,int n,int[][] indices){
        int[] row=new int[m];
        int[] column=new int[n];

        for(int[] k:indices){
            row[k[0]]++;
            column[k[1]]++;
        }

        int rowCount=0;
        int columnCount=0;

        for(int k:row){
            if(k%2!=0)
                rowCount++;
        }
        for(int k:column){
            if(k%2!=0)
                columnCount++;
        }

        return rowCount*(n-columnCount)+columnCount*(n-rowCount);
    }
}
