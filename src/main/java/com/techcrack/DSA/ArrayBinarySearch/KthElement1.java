package com.techcrack.DSA.ArrayBinarySearch;

class KthElement {
    public int kthSmallest(int[][] matrix, int k) {
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int start = matrix[0][0];
        int end = matrix[rowLength - 1][columnLength - 1];

        System.out.println(start + " " + end);



        while(start < end){
            int mid = (start + end) / 2;
            int count = findCount(matrix, mid);


            if(count >= k)
                end = mid;
            else
                start = mid + 1;
        }

        return end;
    }

    private int findCount(int[][] matrix, int target){
        int count = 0;

        for(int k = 0; k < matrix.length; k++)
            count += searchGreater(matrix[k], target);

        return count;
    }

    private int searchGreater(int[] matrix, int target){
        int start = 0;
        int end = matrix.length  - 1;
        int ans = -1;

        while(start <= end){
            int  mid = (start + end) / 2;
            if(matrix[mid] <= target){
                ans = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return ++ans;
    }

    //Priority Queue
    // public int kthSmallest(int[][] matrix, int kth) {
    //     PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());

    //     int n = matrix.length;

    //     for(int k = 0; k < n; k++){
    //         for(int d = 0; d < n; d++){
    //             if(queue.size() < kth)
    //                 queue.offer(matrix[k][d]);
    //             else{
    //                 if(matrix[k][d] < queue.peek()){
    //                     queue.poll();
    //                     queue.offer(matrix[k][d]);
    //                 }
    //             }
    //         }
    //     }

    //     return queue.peek();
    // }
    //Brute Force
    // public int kthSmallest(int[][] matrix, int kth) {
    //     int rowLength = matrix.length;
    //     int columnLength = matrix[0].length;

    //     int[] mergeArray = new int[rowLength * columnLength];
    //     int index = 0;

    //     for(int k = 0; k < rowLength; k++){
    //         for(int d = 0; d < columnLength; d++)
    //             mergeArray[index++] = matrix[k][d];
    //     }

    //     Arrays.sort(mergeArray);

    //     return mergeArray[--kth];
    // }
}