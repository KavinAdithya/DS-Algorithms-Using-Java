package com.techcrack.DSA.arrayBinarySearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestNumber {
    static class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

            for(int[] num : matrix){
                for(int n : num){
                    queue.offer(n);

                    if(queue.size() > k)
                        queue.poll();
                }
            }

            return queue.peek();
        }
    }

    //Brute Force
    public int kthSmallest1(int[][] matrix, int index) {
        int n = matrix.length;

        int[] array = new int[n * n];
        int v = 0;

        for (int[] into : matrix) {
            for (int d = 0; d < n; d++)
                array[v++] = into[d];
        }

        Arrays.sort(array);

        return array[index - 1];
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        int answer = 0;

        while(start <= end){
            int mid = (start + end) / 2;
            int countSmaller = findCount(matrix, mid);

            if(countSmaller >= k){
                answer = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return start;
    }

    private int findCount(int[][] matrix, int maximum){
        int count = 0;

        for(int[] mat : matrix)
            count += binarySearch(mat, maximum);

        return count;
    }

    private int binarySearch(int[] matrix, int target){
        int start = 0;
        int end = matrix.length - 1;
        int answer = -1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(matrix[mid] <= target){
                answer = mid;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return answer + 1;
    }
}
