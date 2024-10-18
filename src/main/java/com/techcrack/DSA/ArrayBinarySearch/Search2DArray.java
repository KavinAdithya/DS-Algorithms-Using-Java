package com.techcrack.DSA.ArrayBinarySearch;

public class Search2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {

        int start = 0;
        int end = matrix.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1])
                return binarySearch(matrix[mid], target);
            else if (matrix[mid][0] > target)
                end = mid - 1;
            else
                start = mid + 1;

        }

        return false;
    }

    private boolean binarySearch(int[] matrix, int target){

        int start = 0;
        int end = matrix.length - 1;

        while(start <= end){

            int mid = (start + end)  / 2;

            if(matrix[mid] ==  target)
                return true;
            else if (matrix[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return false;
    }
}
