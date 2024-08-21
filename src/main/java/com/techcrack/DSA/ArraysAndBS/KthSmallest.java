package com.techcrack.DSA.ArraysAndBS;

import java.util.*;

class KthSmallest {
    // Brute Force
    // Time Complexity -> O(n ^ 2)
    // Space Complexity -> O(n)
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        Comparator<double[]> comparator = (a, b) -> Double.compare(a[0], b[0]);

        List<double[]> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
           for( int j = i + 1; j < arr.length; j++) {
                double value = (double) arr[i] / arr[j];

                list.add(new double[] {value, arr[i], arr[j]});
           } 
        }


        Collections.sort(list, comparator);

        return new int[] {(int)list.get(k - 1)[1], (int)list.get(k - 1)[2]};
    }

    // Priority Queue
    // Time Complexity -> O(n ^ 2)
    // Space Complexity -> O(k)
    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        Comparator<double[]> comparator = (a, b) -> Double.compare(b[0], a[0]);

        PriorityQueue<double[]> queue = new PriorityQueue<>(comparator);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double value = (double) arr[i] / arr[j];

                if (queue.size() == k) {
                    assert queue.peek() != null;
                    if (queue.peek()[0] <= value) continue;
                }

                queue.offer(new double[]{value, arr[i], arr[j]});

                if (queue.size() == k + 1)
                    queue.poll();
            }
        }

        double[] answer = queue.peek();

        return new int[] {(int) answer[1], (int) answer[2]};

    }



    // Binary Search + Two Points
    // Time Complexity -> O(nlog(n)
    // Space Complexity -> O(1)
    public int[] kthSmallestPrimeFraction3(int[] arr, int k) {
        double start = 0.0;
        double end = 1.0;
        int ans1 = 0;
        int ans2 = 0;

        while (start < end) {
            double mid = (start + end) / 2;

            int[] result = countPossibilities(arr, k, mid);

            if (result[0] == k)
                return new int[]{result[1], result[2]};
            else if (result[0] < k)
                start = mid;
            else
                end = mid;
        }

        return null;
    }


    public int[] countPossibilities(int[] arr, int k, double maximum) {
        int count = 0;
        int ans1 = 0;
        int ans2 = 0;
        double maximumFraction = 0.0;
        int length = arr.length;

        int i = 0;
        int j = 0;

        while (i < length) {

            while (j < length && (double) arr[i] / arr[j] > maximum)
                j++;

            count += length - j;

            if (j == length)
                break;

            double currentFraction = (double) arr[i] / arr[j];

            if (currentFraction > maximumFraction) {
                maximumFraction = currentFraction;
                ans1 = arr[i];
                ans2 = arr[j];
            }

            i++;
        }

        return new int[]{count , ans1, ans2};
    }

    // Binary search + linear Search + Binary Search
    // Time Complexity -> 0(log(n)*nlog(n))

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double start = 0.0;
        double end = 1.0;
        int ans1 = 0;
        int ans2 = 0;

        while (start < end) {
            double mid = (start + end) / 2;

            System.out.println("Mid : " + mid);
            int[] result = countPossibilities1(arr, mid);

            if (result[0] == k)
                return new int[]{result[1], result[2]};
            else if (result[0] < k)
                start = mid;
            else
                end = mid;
        }

        return null;
    }

    public int[] countPossibilities1(int[] arr, double maximum) {
        int count = 0;
        int ans1 = 0;
        int ans2 = 0;

        double maximumFraction = 0.0;

        for (int i = 0; i < arr.length - 1; i++) {
            int[] result = countRowFraction(arr, maximum, i);


            count += result[0];

            if (result[1] == 0)
                continue;

            double currentFraction = (double) arr[i] / result[1];



            if (currentFraction > maximumFraction) {
                maximumFraction = currentFraction;
                ans1 = arr[i];
                ans2 = result[1];

            }
        }

        return new int[] {count, ans1, ans2};
    }

    private int[] countRowFraction(int[] arr, double maximum, int numeratorIndex) {
        int start = numeratorIndex + 1;
        int end = arr.length - 1;
        int index = arr.length;
        int value = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            double currentFraction = arr[numeratorIndex] / (double) arr[mid];

            if (currentFraction <= maximum) {
                index = mid;
                value = arr[mid];
                end = mid - 1;
            }
            else
                start = mid + 1;
        }



        return new int[]{ arr.length - index , value};
    }

    public static void main(String[] args) {
        int numerator = 5;
        int denominator = 0;

        double value = (double) numerator / denominator;

        System.out.println(value);

        if (value > 10000)
                System.out.println("Its True");
    }
}