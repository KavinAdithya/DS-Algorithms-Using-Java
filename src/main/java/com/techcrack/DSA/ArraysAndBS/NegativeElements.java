package com.techcrack.DSA.ArraysAndBS;

public class NegativeElements {
    public int countNegatives(int[][] grids) {
        int gridLength=grids[0].length;
        int negativeCount=0;

        for(int[] grid:grids){
            negativeCount+=countNegative(grid,gridLength);
        }

        return negativeCount;
    }

    private int countNegative(int[] grid,int gridLength){
        int start=0;
        int end=gridLength-1;
        int indexNegative=gridLength;

        while(start<=end){
            int mid=(start+end)/2;

            if(grid[mid]<0){
                indexNegative=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }

        return gridLength-indexNegative;
    }
}
