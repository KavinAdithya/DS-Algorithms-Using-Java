package com.techcrack.dsa.weeklyContest.week452;

import java.util.*;

class CleanClassRoom {
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        char[][] grid = new char[m][n];

        int litterId = 0;
        int totalLitters = 0;
        int startR = 0, startC = 0;
        Map<String, Integer> litterMap = new HashMap<>();

        // Step 1: Initialize grid and count litters
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                grid[r][c] = classroom[r].charAt(c);
                if (grid[r][c] == 'S') {
                    startR = r;
                    startC = c;
                } else if (grid[r][c] == 'L') {
                    litterMap.put(r + "," + c, litterId++);
                }
            }
        }

        totalLitters = litterId;
        int fullMask = (1 << totalLitters) - 1;

        // Step 2: BFS setup
        Queue<int[]> queue = new LinkedList<>();
        // [r, c, energyLeft, mask, steps]
        queue.offer(new int[]{startR, startC, energy, 0, 0});

        // visited[r][c][energy][mask]
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << totalLitters];
        visited[startR][startC][energy][0] = true;

        // Step 3: BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], en = curr[2], mask = curr[3], steps = curr[4];

            // Recharge energy
            if (grid[r][c] == 'R') {
                en = energy;
            }

            // Collect litter if any
            if (grid[r][c] == 'L') {
                int id = litterMap.get(r + "," + c);
                mask = mask | (1 << id);  // set that bit
                if (mask == fullMask) return steps;  // all collected
            }

            // Try 4 directions
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                int newEn = en - 1;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && newEn >= 0 && grid[nr][nc] != 'X') {
                    if (!visited[nr][nc][newEn][mask]) {
                        visited[nr][nc][newEn][mask] = true;
                        queue.offer(new int[]{nr, nc, newEn, mask, steps + 1});
                    }
                }
            }
        }

        return -1;  // Impossible to collect all
    }
}
