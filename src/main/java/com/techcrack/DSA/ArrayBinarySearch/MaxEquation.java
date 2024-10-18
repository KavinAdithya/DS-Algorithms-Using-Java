package com.techcrack.DSA.ArrayBinarySearch;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxEquation {
    public int findMaxValueOfEquation1(int[][] points, int range) {
        int answer = Integer.MIN_VALUE;

        for(int k = 0; k < points.length; k++){
            for(int d = k + 1; d < points.length; d++){
                int condition = (int)Math.abs(points[k][0] - points[d][0]);
                if(condition <= range){
                    int value = points[k][1] + points[d][1] + condition;

                    if(value > answer)
                        answer = value;
                }
            }
        }

        return answer;
    }


    public int findMaxValueOfEquation(int[][] points, int k) {
        int maximum = Integer.MIN_VALUE;

        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] point : points) {
            while (!priorityQueue.isEmpty() && point[0] - priorityQueue.peek()[1] > k)
                priorityQueue.poll();

            if (!priorityQueue.isEmpty()) {
                int value = priorityQueue.peek()[0] + point[0] + point[1];

                if (value > maximum)
                    maximum = value;
            }

            priorityQueue.offer(new int[]{point[1] - point[0], point[0]});
        }

        return maximum;
    }
}
