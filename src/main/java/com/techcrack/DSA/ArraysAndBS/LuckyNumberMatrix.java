package com.techcrack.DSA.ArraysAndBS;


import java.util.List;
import java.util.ArrayList;
public class LuckyNumberMatrix {
    /*
        *Given  a 2D Array we needed to find the Lucky Number.
        *Lucky Number is the smallest Number In a row maximum number in column
     */
    public List<Integer> luckyNumbers1(int[][] matrix) {
        List<Integer> min=new ArrayList<>();
        List<Integer> max=new ArrayList<>();

        for(int k=0;k<matrix.length||k<matrix[0].length;k++){
            int small=0;
            int large=0;
            boolean bool1=false;
            boolean bool2=false;
            if(k<matrix.length) {
                small = matrix[k][0];
                bool1 = true;
            }
            if(k<matrix[0].length) {
                large = matrix[0][k];
                bool2 = true;
            }

            for(int d=1;d<matrix.length||d<matrix[0].length;d++){

                if(d<matrix[0].length&&bool1){
                    if(matrix[k][d]<small)
                        small=matrix[k][d];
                }

                if(d<matrix.length&&bool2){
                    if(matrix[d][k]>large)
                        large=matrix[d][k];
                }

            }

            max.add(large);
            min.add(small);
        }

         min.retainAll(max);
        return min;
    }

    //Optimized Solution
    public List<Integer> luckyNumbers(int[][] matrix){
        List<Integer> list=new ArrayList<>();

        for(int k=0;k<matrix.length;k++){
            int minRow=findRow(matrix,k);
            int value=matrix[k][minRow];
            if(findCol(matrix,value,minRow))
                list.add(value);
        }
        return list;
    }

    private int findRow(int[][] matrix,int row){
        int minCol=0;
        for(int k=0;k<matrix[0].length;k++){
            if(matrix[row][k]<matrix[row][minCol])
                minCol=k;
        }
        return minCol;
    }

    private boolean findCol(int[][] matrix,int value,int col){
        for(int row=0;row<matrix.length;row++){
            if(matrix[row][col]>value)
                return false;
        }
        return true;
    }


}
