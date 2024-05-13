package com.techcrack.DSA.Arrays;


import java.util.Arrays;
import java.util.PriorityQueue;
public class MaxValueOfEquation {

    public int findMaxValueOfEquation(int[][] points,int k){
        int max=Integer.MIN_VALUE;
        //priority Queue Object
        PriorityQueue<int[]> pq=new PriorityQueue<>((prev,current)->current[1]-prev[1]);

        for(int[] point:points){
            pq.offer(point);
            for(int[]  p:pq)
                System.out.println(Arrays.toString(p));

            System.out.println("Max "+ Arrays.toString(pq.peek()));
        }
        return max;
    }

    public static void main(String[] args) {
        MaxValueOfEquation maxValueEquation=new MaxValueOfEquation();
        int[][] points={{1,3},{3,0},{9,4},{10,2}};

        maxValueEquation.findMaxValueOfEquation(points,9);
    }
}
