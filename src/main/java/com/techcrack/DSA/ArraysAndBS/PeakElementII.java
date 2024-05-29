package com.techcrack.DSA.ArraysAndBS;

public class PeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            int maxIndex = maxIndex(mat[mid]);

            int top = mid > 0 ? mat[mid - 1][maxIndex] : - 1;
            int bottom = mid < mat.length - 1 ? mat[mid + 1][maxIndex] : -1;

            if(mat[mid][maxIndex] > top && mat[mid][maxIndex] > bottom)
                return new int[]{mid, maxIndex};
            else if(mat[mid][maxIndex] < top)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return new int[]{- 1, - 1};
    }

    private int maxIndex(int[] column){
        int maxIndex = 0;

        for(int k = 1; k < column.length; k++){
            if(column[maxIndex] < column[k])
                maxIndex = k;
        }

        return maxIndex;
    }
}
