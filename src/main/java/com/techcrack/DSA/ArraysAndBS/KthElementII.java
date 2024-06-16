package com.techcrack.DSA.ArraysAndBS;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthElementII {

    //Priority Queue Max Heap
     public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
         Comparator<double[]> comparator = new Comparator<double[]>(){
             public int compare(double[] a, double[] b){
                 return Double.compare(a[0], b[0]);
             }
         };
         Queue<double[]> queue = new PriorityQueue<double[]>(comparator);

         for(int v = 0; v < arr.length; v++){

             for(int n = v + 1; n < arr.length; n++){

                 queue.offer(new double[]{(double) arr[v] / arr[n], arr[v], arr[n]});

                 if(queue.size() > k)
                     queue.poll();
             }
         }

         assert queue.peek() != null;
         return new int[]{
             (int)queue.peek()[1],
             (int)queue.peek()[2]
         };
     }


    //Brute Force
     public int[] kthSmallestPrimeFraction0(int[] arr, int kth) {

         int arrLength = arr.length;
         arrLength--;

         int sumOf = arrLength * (arrLength + 1) / 2;

         arrLength++;

         double[][] answer = new double[sumOf][3];

         int index = 0;

         for(int k = 0; k < arrLength; k++){
             for(int d = k + 1; d < arrLength; d++){
                 answer[index][0] = (double)arr[k] / arr[d];
                 answer[index][1] = (double)arr[k];
                 answer[index][2] = (double)arr[d];

                 index++;
             }

         }

         quickSort(answer, 0, answer.length - 1);

         return new int[]{(int)answer[kth - 1][1], (int)answer[kth - 1][2]};
     }

     private void quickSort(double[][] array, int start, int end){
         if(start < end){
             int mid = partition(array, start, end);
             quickSort(array, start, mid - 1);
             quickSort(array, mid + 1, end);
         }
     }

     private int partition(double[][] array, int start, int end){
         double[] pivot = array[end];
         int pivotIndex = start;

         for(int k = start; k <= end; k++){

             if(pivot[0] > array[k][0]){

                 if(k != pivotIndex){

                     double[] temp = array[k];
                     array[k] = array[pivotIndex];
                     array[pivotIndex] = temp;

                 }

                 pivotIndex++;
             }
         }

         array[end] = array[pivotIndex];
         array[pivotIndex] = pivot;

         return pivotIndex;
     }

     //Priority Queue Max heap
     public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
         Queue<int[]> minHeap =
                 new PriorityQueue<int[]>((a,b) -> {
                     double first = (double)arr[a[0]] / arr[a[1]];
                     double second = (double)arr[b[0]] / arr[b[1]];
                     return Double.compare(first, second);
                 });

         for(int v = 1; v < arr.length; v++){
             minHeap.offer(new int[]{0, v});
         }

         for(int v = 0; v < k - 1; v++){

             int[] index = minHeap.poll();
             assert index != null;
             int left = index[0];
             int right = index[1];

             if(left + 1 < arr.length)
                 minHeap.offer(new int[]{left + 1, right});
         }

         assert minHeap.peek() != null;
         return new int[]{
                 arr[minHeap.peek()[0]],
                 arr[minHeap.peek()[1]]
         };
     }


    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double start = 0.0;
        double end = 1.0;

        while(start <= end){
            double mid = (start + end) / 2.0;
            int[] count = findCount(arr, mid);

            if(count[0] == k)
                return new int[]{count[1], count[2]};
            else if(count[0] > k)
                end = mid;
            else
                start = mid;
        }

        return null;
    }

    private int[] findCount(int[] array, double target){
        int i = 0, j = 1;
        int length = array.length;
        int count = 0;
        double max = 0.0;
        int[] answer = new int[3];

        while(i < length - 1){
            while(j < length && array[i] > array[j] * target)
                j++;

            answer[0] += length - j;

            if(j == length)
                break;

            double ratio = array[i] * 1.0 / array[j];

            if(ratio > max){
                max = ratio;
                answer[1] = array[i];
                answer[2] = array[j];
            }

            i++;


        }

        return answer;
    }
}
