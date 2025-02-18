package com.techcrack.dsa.sorting;

import java.util.*;

class SortArrayFrequency {
    public int[] frequencySort(int[] nums) {
        int max = 0;
        int min = 0;    
        for (int n : nums) {
            if (n > max)
                max = n;
            if (n < min)
                min = n;
        }

        int[] numsFreq = new int[max + 1];
        int[] minFreq = new int[(min * -1) + 1];

        for (int n : nums) {
            if (n >= 0)
                numsFreq[n]++;
            else
                minFreq[n * -1]++;
        }

        int[][] numsMapping = new int[nums.length][];

        int i = 0;
        for (int n : nums) {
            if (n >= 0)
                numsMapping[i] = new int[]{n , numsFreq[n]};
            else
                numsMapping[i] = new int[]{n, minFreq[n * -1]};
            i++;
        }

        Arrays.sort(numsMapping, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1])
                    return b[0] - a[0];
                return a[1] - b[1];
            }
        });


        for (i = 0; i < nums.length; i++) {
            nums[i] = numsMapping[i][0];
        }

        return nums;
    }


    public int[] frequencySort2(int[] nums) {
        Map<Integer, Integer> numsFreq = new HashMap<>();

        for (int n : nums) {
            int val = numsFreq.getOrDefault(n, 0) + 1;
            numsFreq.put(n, val);
        }

        int[][] numsMapping = new int[nums.length][];

        int i = 0;
        for (int n : nums) {
            numsMapping[i] = new int[]{n , numsFreq.get(n)};
            i++;
        }

        Arrays.sort(numsMapping, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1])
                    return b[0] - a[0];
                return a[1] - b[1];
            }
        });


        for (i = 0; i < nums.length; i++) {
            nums[i] = numsMapping[i][0];
        }

        return nums;
    }
}