package com.techcrack.DSA.ArraysAndBS;

import java.util.Set;
import java.util.HashSet;
public class SetMatrixZeros {

    /*
        *Given 2D array we needed to make the row and column
        * which element is zero and based on the index only
        * we needed to make the row and column as zero
     */
    public void setZeroes(int[][] matrix) {
        Set<Integer> row=new HashSet<>();
        Set<Integer> column=new HashSet<>();

        for(int k=0;k<matrix.length;k++){
            for(int d=0;d<matrix[0].length;d++){
                if(matrix[k][d]==0){
                    row.add(k);
                    column.add(d);
                }
            }
        }

        for(Integer d:row){
            for(int k=0;k<matrix[0].length;k++){
                matrix[d][k]=0;
            }
        }


        for(Integer d:column){
            for(int k=0;k<matrix.length;k++){
                matrix[k][d]=0;
            }
        }
    }

    //Optimized Solution
    public void setZeroes1(int[][] matrix){
        boolean firstColumn=false;



        for(int r=0;r<matrix.length;r++){
            if(matrix[r][0]==0){
                firstColumn=true;
            }

            for(int c=1;c<matrix[0].length;c++){
                if(matrix[r][c]==0){
                    matrix[r][0]=0;
                    matrix[0][c]=0;
                }
            }
        }

        for(int r=1;r<matrix.length;r++){
            for(int c=1;c<matrix[0].length;c++){
                if(matrix[r][0]==0||matrix[0][c]==0)
                    matrix[r][c]=0;
            }
        }


        if(matrix[0][0]==0){
            for(int k=1;k<matrix[0].length;k++){
                matrix[0][k]=0;
            }
        }

        if(firstColumn){
            for(int r=1;r<matrix.length;r++){
                matrix[r][0]=0;
            }
        }

    }

}
