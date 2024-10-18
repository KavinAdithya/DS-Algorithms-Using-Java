package com.techcrack.DSA.ArrayBinarySearch;

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



    /*
     * Using binary search algorithm to find the kth smallest fraction element in a given integer array.
     * We Know the Given numbers are sorted, and so we can get the maximum fraction value going to be a 1.0 and a fraction gonna be start at 0.0.
     * We are using these points as start and end applying binary search algorithm.
     * And we are using the binary Search and inside binary search to count the number of fractions that satisfy the mid-value and store the values if they are lesser than or equal to the mid then we needed to move it forward.
     *
     * @Param given an Integer array which is prime numbers used to find the fractions.
     * @Return It will return 2D Array of values which is the kth smallest fraction.
     */

    public int[] kthSmallestPrimeFraction3(int[] arr, int k) {
        double start = 0.0;
        double end = 1.0;

        if( arr == null)
            return null;

        // Applying the binary search to find the maximum target value wich satisfy as kth smallest fraction.
        while(start < end){
            double mid = (start + end ) / 2;

            // Counting the fraction which is lesser than the mid-fraction
            double[] count = binarySearch(mid, arr);


            // Checking the count for mid-fraction value satisfy means terminate the program return the answer.
            if(count[0] == k)
                return new int[]{
                        (int)count[1],
                        (int)count[2]
                };
            else if(count[0] < k)
                start = mid;
            else
                end = mid;
        }

        return null;
    }


    // Binary Search to find the values which is lesser than the mid-fraction.
    // @Param Target element is maximum fraction value.
    // @Param arr it is array which contains all elements needed to find the fraction from it.

    private double[] binarySearch(double target, int[] arr){
        double[] countFraction = null;
        int count = 0;
        double maxFraction = 0.0;

        // iterating the array and passing the element to the findCount Method .
        for(int i = 0; i < arr.length - 1; i++){

            double[] currentFraction = findCount(target, arr, i);

            if(currentFraction[2] == -1)
                continue;

            count += (int) currentFraction[0];

            double fraction = currentFraction[1] / currentFraction[2];

            //Updating the fraction maximum value
            if(countFraction == null || fraction > maxFraction){
                countFraction = currentFraction;
                maxFraction = fraction;
            }
        }

        if(countFraction == null)
            return new double[]{0.0, 0.0, 0.0};
        countFraction[0] = count;
        // Returning the result who invokes this method.
        return countFraction;
    }


    // Actually Counting the fractions that are lesser than the target value.
    // @Param target is used to maximize the fraction.
    // @Param index is starting point and numerator for fraction.
    // @Param arr it is array which contained all elements needed to find the fraction from it.

    private double[] findCount(double target, int[] arr, int index){
        int  start = index + 1;
        int end = arr.length - 1;

        //Finding the index that satisfies the target value lesser than or equal to.
        double[] answer = new double[3];

        while(start <= end){
            int mid = (start + end ) / 2;

            double fraction = (double)arr[index] / arr[mid];

            if(fraction <= target){
                answer[0] = arr.length - mid;
                answer[1] = arr[index];
                answer[2] = arr[mid];
                end = mid - 1;
            }
            else
                start = mid + 1;

        }

        //Returning the count, fraction and their values.
        return answer;

    }
}
