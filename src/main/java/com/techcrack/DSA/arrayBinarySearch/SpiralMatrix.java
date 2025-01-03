package com.techcrack.DSA.arrayBinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    List<Integer> list=new ArrayList<>();
    //Given An Array We needed traverse the array in spiral matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        //Four pointers to point the end of 2D matrix
        int left=0;
        int top=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;

        //taking four pointers and reducing its size
        //if the opposite pointer crossed each other loop termination will happen..
        while((top<=bottom) && (left<=right)){
            rowPrinter(matrix,top,left,right,true);
            columnPrinter(matrix,right,top+1,bottom,true);
            if(top!=bottom)
                rowPrinter(matrix,bottom,right-1,left,false);
            if(left!=right)
                columnPrinter(matrix,left,bottom-1,top+1,false);
            top++;
            left++;
            bottom--;
            right--;
        }
        return list;
    }

    //Method for printing row constant
    private void rowPrinter(int[][] matrix,int row,int start,int end,boolean increment){
        int counter=increment?(end-start+1):(start-end+1);

        int n=0;

        //Adding the elements
        while(n<counter){
            list.add(matrix[row][start]);
            if(increment)
                start++;
            else
                start--;

            n++;

        }
        System.out.println(list);
    }

    //Method for column printer
    private void columnPrinter(int[][] matrix,int column,int start,int end,boolean increment){
        int counter=increment?(end-start+1):(start-end+1);

        int n=0;

        while(n<counter){
            list.add(matrix[start][column]);
            if(increment)
                start++;
            else
                start--;
            n++;
        }
        System.out.println(list);
    }
}
