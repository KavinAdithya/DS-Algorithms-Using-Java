package com.techcrack.dsa.sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueuePriority {
    static void priorityQueue(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int a : arr) {
            queue.offer(a);
            System.out.println(queue);
            System.out.println(queue.peek());
            int poll = queue.isEmpty() ? 0 : queue.poll();
            System.out.println(poll);
            queue.offer(poll);
        }
    }

    public static void main(String[] args) {

        priorityQueue(new int[]{3,2,3,1,2,4,5,5,6});
    }
}
