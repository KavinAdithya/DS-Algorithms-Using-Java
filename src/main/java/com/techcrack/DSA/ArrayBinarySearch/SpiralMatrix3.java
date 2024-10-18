package com.techcrack.DSA.ArrayBinarySearch;

public class SpiralMatrix3 {

    /*
        *Given 2d array length we needed to traverse
        * the array from given element like a spiral in clockwise
        * if we cross the boundary we needed to continue to wait to
        * reach our element likewise traverse the 2D array
     */

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int[][] result=new int[rows*cols][2];
        int d=0;
        int len=0;
        int i=0;
        result[i++]=new int[]{rStart,cStart};
        int[] direction={0,1,0,-1,0};

        while(i<(rows*cols)){
            if(d==0||d==2){
                len++;
            }

            for(int k=0;k<len;k++){
                rStart+=direction[d];
                cStart+=direction[d+1];

                if(rStart<rows&&rStart>=0&&cStart<cols&&cStart>=0){
                    result[i++]=new int[]{rStart,cStart};
                }
            }

            d=++d%4;
        }

        return result;
    }
}
