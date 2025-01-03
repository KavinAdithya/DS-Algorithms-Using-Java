package com.techcrack.DSA.arrayBinarySearch;

import java.util.*;

public class EquationMaximum {

    // max heap
    public int findMaxValueOfEquation(int[][] points, int k) {
        Comparator<int[]> comparator = (a, b) -> b[0] - a[0];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(comparator);

        int max = Integer.MIN_VALUE;

        for(int[] point : points){
            while( ! priorityQueue.isEmpty() && point[0] - priorityQueue.peek()[1] > k)
                priorityQueue.poll();

            if(! priorityQueue.isEmpty()){
                int equationValue = priorityQueue.peek()[0] + point[0] + point[1];
                if(equationValue > max)
                    max = equationValue;
            }

            priorityQueue.offer(new int[]{point[1] - point[0], point[0]});
        }

        return max;

    }

    // brute force
    public int findMaxValueOfEquation1(int[][] points, int k) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++ ){
                int value = points[j][0] - points[i][0];

                if(value <= k){
                    int maxValue = value + points[j][1] + points[i][1];
                    if(maxValue > max)
                        max = maxValue;
                }
            }
        }

        return max;
    }
}
