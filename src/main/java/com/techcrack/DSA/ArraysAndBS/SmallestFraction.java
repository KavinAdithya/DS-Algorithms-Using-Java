package com.techcrack.DSA.ArraysAndBS;

import java.util.*;
public class SmallestFraction {
    public int[] kthSmallestPrimeFraction(int[] numbs, int kth) {

        //Storing the fraction values with values as array
        List<double[]> list = new ArrayList<>();

        //finding the fraction and storing on a list
        for(int k = 0; k < numbs.length; k++){

            for(int v = k + 1; v < numbs.length; v++){
                list.add(new double[]{
                        (double)numbs[k] / numbs[v],
                        numbs[k],
                        numbs[v]
                });
            }
        }

        //Creating a comparator to instruct the sort method how to sort
        Comparator<double[]> comparator = new Comparator<double[]>(){
            public int compare(double[] a, double[] b){
                if(a[0] > b[0])
                    return 1;
                else if(a[0] == b[0])
                    return 0;
                return -1;
            }
        };

        //Sorting the list in ascending order based on fraction values
        list.sort(comparator);

        double[] answer = list.get(kth - 1);

        return new int[]{(int)answer[1], (int)answer[2]};
    }

    /*
     * Method to find the kth smallest element fraction in an array.
     * Using priority Queue, we are finding the solution
     * @Param an integer array, int kth to find the smallest fraction
     * @Return an integer array where the kth smallest element numerator and denominator
     */
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {

        //Priority Queue to hold the kth maximum elements in ascending order
        PriorityQueue<double[]> maxQueue = new PriorityQueue<double[]>((a, b) -> Double.compare(b[0], a[0]));

        //Storing array length
        int arrLength = arr.length;

        //Generating a fraction and storing on the queue
        for(int i = 0; i < arrLength; i++){
            for(int j = i + 1; j < arrLength; j++){
                //Generating the fraction
                double fraction = (double)arr[i] / arr[j];


                // Checking the maxQueue size is equal to k and if the new fraction is lesser than the top of queue fraction no opertion
                if(maxQueue.size() == k) {
                    assert maxQueue.peek() != null;
                    if (maxQueue.peek()[0] < fraction) continue;
                }

                maxQueue.offer(new double[]{
                        fraction,
                        arr[i],
                        arr[j]
                });

                //Checking the maxQueue size exceeds or not. if it removes
                if(maxQueue.size() > k)
                    maxQueue.poll();


            }
        }

        //Getting the top of the queue, which is our answer
        double[] answer = maxQueue.peek();

        //Returning the answer to the invoker
        assert answer != null;
        return new int[]{
                (int)answer[1],
                (int)answer[2]
        };
    }
}
