package com.techcrack.dsa.arrayBinarySearch;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int top=rStart;
        int bottom=rStart;
        int left=cStart;
        int right=cStart;

        int[][] result=new int[rows*cols][2];

        while(left<cols||right>=0||top<rows||bottom>=0){

        }
        return result;
    }

    private void printInArray(int[][] result,int row,int column,int end,boolean checkRow,boolean increment){
        int size=(end-column+1);
        if(!checkRow){
            int temp=row;
            row=column;
            column=temp;
            size=(column-end+1);
        }
        int length=0;

        while(length<size){

        }

    }
}
