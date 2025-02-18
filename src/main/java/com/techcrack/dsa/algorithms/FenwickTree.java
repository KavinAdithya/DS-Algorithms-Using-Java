package com.techcrack.dsa.algorithms;

import java.util.Arrays;

public class FenwickTree {

    public static void fenwickTree(int[] array) {
        int[] prefixSum = new int[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            update(prefixSum, i + 1, array[i]);
        }

        System.out.println(Arrays.toString(prefixSum));
        System.out.println(query(prefixSum, prefixSum.length - 1) - query(prefixSum, 1));
    }
    
    public static void update(int[] prefixSum, int index, int value) {
        int n = prefixSum.length;
        
        while (index < n) {
            prefixSum[index] += value;
            
            index += (index & (-index ));
        }
    }

    public static int query(int[] prefixSum, int index) {
        int sum = 0;

        while (index > 0) {
            sum += prefixSum[index];
            index -= index & (- index);
        }
        
        return sum;
    }

    public static void main(String[] args) {
        fenwickTree(new int[] {1, 2, 3, 4, 5});
    }
    
}

