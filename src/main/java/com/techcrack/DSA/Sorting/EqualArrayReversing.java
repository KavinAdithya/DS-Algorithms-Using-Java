package com.techcrack.DSA.Sorting;

import java.util.Arrays;

class EqualArrayReversing {
    public boolean canBeEqual1(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);

        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i])
                return false;
        }

        return true;
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int max = 0;

        for (int ar : arr) {
            if (ar > max)
                max = ar;
        }

        int[] arrHash = new int[max + 1];

        for (int ar : arr)
            arrHash[ar]++;

        for (int tar : target) {
            if (tar > max || arrHash[tar] == 0)
                return false;
            arrHash[tar]--;
        }

        return true;
    }
}