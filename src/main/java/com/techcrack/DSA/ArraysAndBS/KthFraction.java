package com.techcrack.DSA.ArraysAndBS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthFraction {

    //Max priorityQueue
    public int[] kthSmallestPrimeFraction(int[] arr, int index) {
        Comparator<double[]> comparator = new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                if(b[0] > a[0])
                    return 1;
                return -1;
            }
        };
        Queue<double[]> queue
                = new PriorityQueue<>(comparator);

        for(int k = 0; k < arr.length; k++){
            for(int d = 0; d < arr.length; d++){
                double value =  (double)arr[k] / arr[d];
                if(queue.size() < index)
                    queue.
                            offer(
                                    new double[]{
                                            value,
                                            arr[k],
                                            arr[d]
                                    });
                else {
                    assert queue.peek() != null;
                    if(value < queue.peek()[0]){
                        queue.offer(
                                new double[]{
                                        value,
                                        arr[k],
                                        arr[d]
                                }
                        );
                        if(queue.size() > index)
                            queue.poll();
                    }
                }
            }
        }

        double[] answer = queue.poll();
        assert answer != null;
        return new int[]{(int)answer[1], (int)answer[2]};
    }

    //Brute Force
    public int[] kthSmallestPrimeFraction5(int[] arr, int index) {
        int n = arr.length;
        n--;

        int size = n * (n + 1) / 2;

        n++;

        double[][] array = new double[size][3];
        int v = 0;

        for(int k = 0; k < n; k++){
            for(int d = k + 1; d < n; d++){
                array[v][0] = (double)arr[k] / arr[d];
                array[v][1] = arr[k];
                array[v++][2] = arr[d];
            }
        }

        Comparator<double[]> comparator = new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                if(b[0] < a[0])
                    return 1;
                return -1;
            }
        };
        Arrays.sort(array, comparator);

        // for(double[] ar : array)
        //     System.out.println(Arrays.toString(ar));
        index--;

        return new int[]{(int)array[index][1], (int)array[index][2]};
    }
}
