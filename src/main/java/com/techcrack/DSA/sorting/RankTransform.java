package com.techcrack.DSA.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RankTransform {
    public int[] arrayRankTransform1(int[] arr) {
        
        if (arr == null || arr.length == 0)
            return arr;

        int length = arr.length;

        int[][] arrIndex = new int[length][];

        for (int i = 0; i < length; i++) 
            arrIndex[i] = new int[]{arr[i], i};
        
        Arrays.sort(arrIndex, ((a, b) -> Integer.compare(a[0], b[0])));

        int[] rankArray = new int[length];
        int currentRank = 1;

        rankArray[arrIndex[0][1]] = currentRank;

        for (int i = 1; i < length; i++) {
            if (arrIndex[i][0] != arrIndex[i - 1][0])
                currentRank++;
            
            rankArray[arrIndex[i][1]] = currentRank;
        }

        return rankArray;
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0)
            return arr;

        int[] sortedArr = arr.clone();

        Map<Integer, Integer> rankMap = new HashMap<>();

        Arrays.sort(sortedArr);
        int curRank = 1;

        for (int num : sortedArr) {
            if (! rankMap.containsKey(num)) {
                rankMap.put(num, curRank);
                curRank++;
            }
        }

        int[] rank = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            rank[i] = rankMap.get(arr[i]);

        return rank;
    }
}