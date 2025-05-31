package com.techcrack.dsa.recursion;

public class FindX {
    public static int findX(int n, int a, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        int curValue = (int)Math.pow(a, mid);

        if (curValue == n) {
            return mid;
        }
        else if (curValue > n) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }

        return findX(n, a, start, end);
    }


    public static int findXIterate(int n, int a, int curX, int x) {
        if (curX > n) {
            return -1;
        }

        if (curX == n) {
            return x;
        }

        return findXIterate(n, a, curX * a, x + 1);
    }

    public static void main(String[] args) {
//        int x =  findX(16, 4, 0, 16);
//        System.out.println(x);

        System.out.println(findXIterate(16, 4, 1, 0));
    }
}
