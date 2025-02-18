package com.techcrack.dsa.dynamicProgramming;

public class JumpGame7 {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        if (s == null || s.isEmpty())
            return false;

        int n = s.length();

        int[] prefixSum = new int[n + 1];

        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;

        prefixSum[1] = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                int left = Math.max(0, i - maxJump);
                int right = i - minJump;

                if (right >= left && prefixSum[right + 1]  - prefixSum[left] > 0) {
                    isVisited[i] = true;   
                }
            }

            prefixSum[i + 1] = prefixSum[i] + (isVisited[i] ? 1 : 0);
        }

        return isVisited[n - 1];
    }
}