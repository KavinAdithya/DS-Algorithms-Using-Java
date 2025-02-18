package com.techcrack.dsa.arrayBinarySearch;

import java.util.*;


public class Fraction {

    // Brute Force
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        Comparator<double[]> comparator = (a, b) -> Double.compare(a[0], b[0]);
        //PriorityQueue<double[]> queue = new PriorityQueue<>();

        List<double[]> list = new ArrayList<>();

        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                list.add(new double[] {
                        (double) arr[i] / arr[j],
                        arr[i],
                        arr[j]
                });
            }
        }

        Collections.sort(list, comparator);

        double[] result = list.get(k - 1);

        return new int[] {
                (int) result[1],
                (int) result[2]
        };
    }

    // Priority Queue
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Comparator<double[]> comparator = (a, b) -> Double.compare(b[0], a[0]);
        PriorityQueue<double[]> queue = new PriorityQueue<>(comparator);


        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                double fractionValue = (double) arr[i] / arr[j];
                if (queue.size() == k && queue.peek()[0] < fractionValue)
                    continue;
                queue.offer(
                        new double[] {
                                fractionValue,
                                (double) arr[i],
                                (double) arr[j]
                        }
                );

                if (queue.size() > k)
                    queue.poll();
            }
        }



        double[] result = queue.peek();

        return new int[] {
                (int) result[1],
                (int) result[2]
        };
    }


    static class Solution2 {
        /*

            @param arr is sequence of integer to derive the th fraction using the k
            @param k is the used to retrieve the kth smallest faction which is derived from array

            We are using binary search because the input is naturally sorted
            We know the value are in ascending order and so we conclude the fraction values between 0.0 and 1.0
            following mid value is passed to the findCont() method
            It will count the posible fraction for given mid value

            If it count is higher than the count then we move end to mid
            else move the start to mid
            Equal means answer return it

            @return faction Values which is k th smallest value

        */
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {

            // Checking the edge case is the arr is null
            if (arr == null)
                return null;

            // Initialising the starting and ending range
            double start = 0.0;
            double end = 1.0;

            // It will fails until start is higher than the end
            while (start <= end) {

                // calculating the mid value
                double mid = (start + end) / 2;

                // Invoking the faction count method to count the possible which is smaller than mid;
                int[] fractionCount = findCount(arr, mid);


                // Checking the result count is equal or not
                if (fractionCount[0] == k) {
                    // returning result
                    return new int[]
                            { fractionCount[1], fractionCount[2]};
                }
                else if (fractionCount[0] < k)
                    start = mid;
                else
                    end = mid;
            }

            return new int[]{-1, -1};
        }

        public int[] findCount(int[] arr, double target) {
            int count = 0;
            int ans1 = 0;
            int ans2 = 0;
            double maxFraction = 0.0;

            int start = 0;
            int end = 1;
            int length = arr.length ;

            while (start < length - 1) {
                while (end < length && (double) arr[start] / arr[end] > target)
                    end++;

                if (end == length)
                    break;

                double currentFraction = (double)arr[start] / arr[end];


                count += (length - end);

                if (currentFraction > maxFraction) {
                    maxFraction = currentFraction;
                    ans1 = arr[start];
                    ans2 = arr[end];
                }

                start++;

            }

            return new int[] {count, ans1, ans2};
        }
    }
    static class Solution1 {
        /*

            @param arr is sequence of integer to derive the th fraction using the k
            @param k is the used to retrieve the kth smallest faction which is derived from array

            We are using binary search because the input is naturally sorted
            We know the value is in ascending order and so we conclude the fraction values between 0.0 and 1.0
            following mid value is passed to the findCont() method
            It will count the posible fraction for given mid value

            If it count is higher than the count then we move end to mid
            else move the start to mid
            Equal means answer return it

            @return faction Values which is k th smallest value

        */
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {

            // Checking the edge case is the arr is null
            if (arr == null)
                return null;

            // Initialising the starting and ending range
            double start = 0.0;
            double end = 1.0;

            // It will fails until start is higher than the end
            while (start <= end) {

                // calculating the mid value
                double mid = (start + end) / 2;

                // Invoking the faction count method to count the possible which is smaller than mid;
                int[] fractionCount = findCount(arr, mid);

                // Checking the result count is equal or not
                if (fractionCount[0] == k) {
                    // returning result
                    return new int[]
                            { fractionCount[1], fractionCount[2]};
                }
                else if (fractionCount[0] < k)
                    start = mid;
                else
                    end = mid;
            }

            return new int[]{-1, -1};
        }
    /*
        @param arr sorted array is used to manipulate the facrtion values from it
        @param mid target value to count the faction lesser than it

        Used to count the fraction value which is lesser than the mid value

        @return integer array consists of three element
            1 count
            2 Numerator Value
            3 Denominator Value
    */

        public int[] findCount(int[] arr, double target) {
            // To store the count
            int count = 0;

            // To store the numerator value
            int ans1 = 0;

            // To store the denominator value
            int ans2 = 0;

            // Storing the maximum possible of faction value
            double maxFractionValue = Double.MIN_VALUE;

            // length
            int length = arr.length;

            // Traversing and finding the possible fraction values
            for (int i = 0; i < length - 1; i++) {

                // Numerator is i of array
                // Deniminator is finding which maximum satisfy the condition
                int[] countFraction = binarySearch(arr, arr[i], i + 1, length, target);

                // Adding the result count to the local count
                count += countFraction[0];

                if (countFraction[0] == 0)
                    continue;

                double fractionValue = (double) arr[i] / countFraction[1];

                // Checking the maximum value
                if (fractionValue > maxFractionValue) {
                    maxFractionValue = fractionValue;
                    ans1 = arr[i];
                    ans2 = countFraction[1];
                }
            }

            return new int[] {count, ans1, ans2};
        }

    /*
        @param integer array which is used to find the smallest fractions
        @param numerator element
        @param start intiall index of range to check the possible numerator
        @param end of the range
        @param target where we are finding the fraction lesser than it

        Using Binary Search to find the count possible for each numerator in an array

        @return integer array of two elements
            1 count
            2 denominator value
    */

        public int[] binarySearch(int[] arr, double numerator, int start, int end, double target) {
            boolean solution = true;
            // It will terminate while start is equal to the end

            while (start < end) {
                int mid = (start + end) / 2;
                double fractionValue = numerator / arr[mid];

                if (fractionValue <= target){
                    solution = false;
                    end = mid;
                }
                else
                    start = mid + 1;
            }

            if (solution)
                return new int[]{0, 0};

            return new int[] {arr.length - start, arr[start]};
        }
    }
}
