package com.techcrack.DSA.Strings;

public class FenwickTree {
    final int[] arr;

    public FenwickTree(int n) {
        arr = new int[n + 1];
    }

    public void update(int id, int value) {
        while (id < arr.length) {
            arr[id] += value;
            id += (id & -id);
        }
    }

    public int query(int id) {
        int sum = 0;

        while (id > 0) {
            sum += arr[id];
            id -= (id & -id);
        }

        return sum;
    }
}
