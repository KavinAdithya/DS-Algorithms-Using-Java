package com.techcrack.DSA.ArraysAndBS;

public class KthFractionBinary {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double start = 0.0;
        double end = 1.0;

        while(start < end){
            double mid = (start + end) / 2;
           // int[] count = findCounts(arr, mid);

            int[] count = countElementsUsingTwoPointers(arr, mid);
            //System.out.println(mid + " " + count[0]);

            if(count[0] == k)
                return new int[]{count[1], count[2]};
            else if(count[0] > k)
                end = mid;
            else
                start = mid;
        }

        return null;
    }

    private int[] findCounts(int[] arr, double maximum){
        int counts = 0;
        double maxRatio = Double.MIN_VALUE;
        int ans1 = 0, ans2 = 0;

        for(int k = 0; k < arr.length - 1; k++){
            int[] count = countIt(arr, k, maximum);
            counts += count[0];

            if(count[1] == -1 && count[2] == -1)
                continue;

            double curRatio = (double)count[1] / count[2];

            if(curRatio > maxRatio){
                maxRatio = curRatio;
                ans1 = count[1];
                ans2 = count[2];
            }
        }

        return new int[]{counts, ans1, ans2};
    }

    private int[] countIt(int[] arr, int top, double maximum){
        int start = top + 1;
        int end = arr.length - 1;
        int count = arr.length ;
        int ans1 = arr[top];
        int ans2 = arr[top];

        while(start <= end){
            int mid = (start + end) / 2;

            if(((double)arr[top] / arr[mid]) <= maximum){
                count = mid;
                ans2 = arr[mid];
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        if(count == arr.length)
            return new int[]{0, -1, -1};
        return new int[]{arr.length - count , ans1, ans2};
    }

    private int[] countElementsUsingTwoPointers(int[] arr, double maximum){
        int i = 0;
        int j = 1;
        int count = 0;
        double maxRatio = 0.0;
        int ans1 = 0, ans2 = 0;
        int length = arr.length;

        while(i < length - 1){
            while(j < length && ((double) arr[i] / arr[j]) > maximum)
                j++;
            count += (length - j);

            if(j == length)
                break;

            double localRatio = (double) arr[i] / arr[j] ;

            if(localRatio > maxRatio){
                maxRatio = localRatio;
                ans1 = arr[i];
                ans2 = arr[j];
            }

            i++;
        }

        return new int[]{count, ans1, ans2};
    }


    public static void main(String[] args) {
        KthFractionBinary kthFractionBinary = new KthFractionBinary();

        int[] array = {1, 2, 3, 5};
        int[] answer = kthFractionBinary.kthSmallestPrimeFraction(array, 3);
        System.out.println(answer[0] + " " + answer[1]);
    }
}
