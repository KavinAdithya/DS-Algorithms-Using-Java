package com.techcrack.DSA.ArraysAndBS;

public class SquareMatrix {

    //Given a array we needed to transpose the given matrix
    public int[][] transpose(int[][] matrix) {
        if(matrix.length==matrix[0].length)
            return squareTranspose(matrix);
        return normalTranspose(matrix);
    }

    //SquareMatrix Transpose
    private int[][] squareTranspose(int[][] matrix){
        for(int k=0;k<matrix.length;k++){
            for(int r=k+1;r<matrix.length;r++){
                int top=matrix[k][r];
                matrix[k][r]=matrix[r][k];
                matrix[r][k]=top;
            }
        }
        return matrix;
    }

    private int[][] normalTranspose(int[][] matrix){
        int[][] array=new int[matrix[0].length][matrix.length];

        for(int k=0;k<matrix.length;k++){
            for(int d=0;d<matrix[0].length;d++){
                array[d][k]=matrix[k][d];
            }
        }

        return array;
    }

}
