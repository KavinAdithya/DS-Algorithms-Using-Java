package com.techcrack.dsa.recursion.general;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    // memoization
    static final Map<Integer, String> cache = new HashMap<>();

    static String arithmeticExpressions(int[] arr, int idx, int val) {
        val %= 101; // modulo 101 to avoid overflow

        // base case: if we reached end and value is divisible by 101
        if (idx == arr.length) {
            return (val % 101 == 0) ? "" : null;
        }

        final int key = idx * 101 + val;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        String result = null;

        // Try addition
        String add = arithmeticExpressions(arr, idx + 1, val + arr[idx]);
        if (add != null) {
            result = "+" + arr[idx] + add;
        }

        // Try subtraction
        if (result == null) {
            String sub = arithmeticExpressions(arr, idx + 1, val - arr[idx]);
            if (sub != null) {
                result = "-" + arr[idx] + sub;
            }
        }

        // Try multiplication
        if (result == null) {
            String mul = arithmeticExpressions(arr, idx + 1, val * arr[idx]);
            if (mul != null) {
                result = "*" + arr[idx] + mul;
            }
        }

        cache.put(key, result); // memoize final result (even if null)
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 10, 81};
        String result = arithmeticExpressions(arr, 1, arr[0]);
        System.out.println(result == null ? "No solution" : arr[0] + result);

        System.out.println(cache);
    }
}
