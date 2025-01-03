package com.techcrack.DSA.arrayBinarySearch;

public class DiagonalSum {
    /*
    *2D ARRAY IS GIVEN WHICH IS A SQUARE MATRIX WE NEEDED TO FIND THE PRIMSRY AND SECONDARY DIAGONAL SUM
     */
    public int diagonalSum(int[][] mat) {
        int row=mat.length;
        int column=0;
        int r=row-1;
        int sum=0;

        //Adding primary and secondary diagonals
        for(;column<row;column++){
            sum+=mat[column][column];
            if(r!=column)
                sum+=mat[column][r];
            r--;
        }
        return sum;
    }
}
