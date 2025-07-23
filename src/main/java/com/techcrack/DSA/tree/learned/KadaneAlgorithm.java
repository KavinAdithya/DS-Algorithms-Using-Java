package com.techcrack.dsa.tree.learned;

public class KadaneAlgorithm {
    public int maxSub(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        int sum = 0;
        int startI = -1;
        int endI = -1;
        int start = 0;

        for (int i = 0; i < n; ++i) {
            if (sum == 0) {
                start = i;
            }

            sum += arr[i];

//            max = Math.max(max, sum);
//            sum = Math.max(sum, 0);

            if (sum > max) {
                max = sum;
                startI = start;
                endI = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        for (int i = startI; i <= endI; ++i) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(new KadaneAlgorithm().maxSub(arr));
    }
}
