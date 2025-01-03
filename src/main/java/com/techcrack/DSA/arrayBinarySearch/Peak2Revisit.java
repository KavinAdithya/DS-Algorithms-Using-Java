package com.techcrack.DSA.arrayBinarySearch;
public class Peak2Revisit {
    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length;

        while(start <= end){
            int mid = (start + end) / 2;

            int maxIndex = findMaximum(mat, mid);

            int leftIndex = mid > 0 ? mat[maxIndex][mid - 1] : -1;
            int rightIndex = mid + 1 < mat[0].length ? mat[maxIndex][mid + 1] : -1;

            if(leftIndex < mat[maxIndex][mid] && rightIndex < mat[maxIndex][mid])
                return new int[]{maxIndex, mid};
            else if(leftIndex > mat[maxIndex][mid])
                end = mid - 1;
            else
                start = mid + 1;
        }

        return null;
    }


    private int findMaximum(int[][] mat, int midIndex){
        int maxIndex = 0;
        for(int k = 1; k < mat.length; k++){
            if(mat[maxIndex][midIndex] < mat[k][midIndex])
                maxIndex = k;
        }

        return maxIndex;
    }
}