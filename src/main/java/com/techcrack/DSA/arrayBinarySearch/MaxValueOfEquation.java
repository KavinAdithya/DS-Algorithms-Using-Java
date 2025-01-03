package com.techcrack.DSA.arrayBinarySearch;


import java.util.Arrays;
import java.util.PriorityQueue;
public class MaxValueOfEquation {

    public int findMaxValueOfEquation(int[][] points,int k){
        int max=Integer.MIN_VALUE;
        //priority Queue Object
        PriorityQueue<int[]> pq=new PriorityQueue<>((prev,current)->current[1]-prev[1]);

        for(int[] point:points){

            for(int[]  p:pq)
                System.out.println(Arrays.toString(p));

            while(!pq.isEmpty()&&point[0]-pq.peek()[0]>k)
                pq.poll();

            if(!pq.isEmpty()){
                int[] localValue=pq.peek();
                int localMax=point[1]-localValue[0]+localValue[1]+point[0];
                max=Math.max(localMax,max);
            }

            pq.offer(new int[]{point[1]-point[0],point[0]});
        }
        return max;
    }

    public static void main(String[] args) {
        MaxValueOfEquation maxValueEquation = new MaxValueOfEquation();
        int[][] points = {{1,3},{2,0},{5,10},{6,-10}};

        int k=maxValueEquation.findMaxValueOfEquation(points, 1);

        System.out.println(k);
    }
}
