package com.techcrack.dsa.recursion;

import java.util.*;

class NDigitIncreaseOrder {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            
            return ans;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }
        
        int max = 1;
        
        n -= 1;
        
        while (n > 0) {
            max *= 10;
            n--;
        }
       
       System.out.println(max + " " + queue);
       
        while (! queue.isEmpty()) {
            int top = queue.poll();
            
            if (top > max) {
                ans.add(top);
            }
            else {
                int lastDigit = top % 10;
                
                for (int next = lastDigit + 1; next <= 9; next++) {
                    queue.offer(top * 10 + next);
                }
            }
            
            System.out.println(queue);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(increasingNumbers(2));
    }
}
