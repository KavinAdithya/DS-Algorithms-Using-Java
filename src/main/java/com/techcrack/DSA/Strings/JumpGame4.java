package com.techcrack.DSA.Strings;

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGame4 {
    public boolean canReach1(String s, int minJump, int maxJump) {
        int length = s.length() - 1;
        int i = 0;
        int j = minJump;
        int end = Math.min(maxJump, length);

        while (j < end + 1) {
            if (s.charAt(j) == '0') {
                i = j;
                j += minJump;
                end = Math.min(i + maxJump, length);
            }
            else
                j++;
        }

        return i == length;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                while ( !deque.isEmpty() && i > deque.peek() + maxJump)
                    deque.poll();

                if (deque.isEmpty())
                    return false;

                int previousPlace = deque.peek();
                if (i >= previousPlace + minJump && i <= previousPlace + maxJump){
                    deque.offer(i);

                    if (i == s.length() - 1)
                        return true;
                }
            }
            // System.out.println(deque);
        }

        return false;
    }
}
