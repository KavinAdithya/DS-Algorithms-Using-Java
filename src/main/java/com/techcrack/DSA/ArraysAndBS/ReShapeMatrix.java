package com.techcrack.DSA.ArraysAndBS;

public class ReShapeMatrix {
    //Given a @d matrix and given another row and column size we needed to
    //Reshape the matrix if not possible return the original matrix
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int r1=mat.length;
        int c1=mat[0].length;

        if((r1*c1)==(r*c)){
            mat=reshape(mat,r,c,r1,c1);
        }

        return mat;
    }


    //Actual reshape of an array
    private int[][] reshape(int[][] mat,int r0,int c0,int r1,int c1){
        int[][] array=new int[r0][c0];
        int row=0;
        int column=0;

        for(int k=0;k<r0;k++){
            for(int d=0;d<c0;d++){
                array[k][d]=mat[row][column];


                column++;

                if(column==c1){
                    column=0;
                    row++;
                }

            }
        }

        return array;
    }
}