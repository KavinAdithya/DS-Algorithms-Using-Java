package com.techcrack.DSA.sorting;

import java.util.*;

class KthLargestNumber {
    public int findKthLargest(int[] nums, int k) {
        
        if (nums == null || nums.length < k)
            return 0;

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int size = nums.length - k + 1
        ;

        for (int num : nums) {
            if (queue.size() < size || (! queue.isEmpty() && num < queue.peek()))
                queue.offer(num);

            if (queue.size() > size)
                queue.poll();            
        }

        return queue.isEmpty() ? 0 : queue.peek();
    }

    public int findKthLargest2(int[] nums, int k) {

        if (nums == null || nums.length < k)
            return 0;

        Queue<Integer> queue = new PriorityQueue<>();


        for (int num : nums) {
            if (queue.size() < k || (! queue.isEmpty() && num > queue.peek()))
                queue.offer(num);

            if (queue.size() > k)
                queue.poll();
        }

        return queue.peek();
    }
}