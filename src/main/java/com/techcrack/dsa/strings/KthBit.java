package com.techcrack.dsa.strings;

class KthBit {

    // Brute Force
    // Time Complexity -> 0(n ^ 2)
    // Space Complexity -> 0(n)
    public char findKthBi1(int n, int k) {
        StringBuilder binaryString = new StringBuilder();

        binaryString.append('0');

        for (int i = 1; i < n; i++) {
            binaryString.append("1");
            invertString(binaryString);
    
            if (binaryString.length() > k - 1)
                break;
        }

        return binaryString.charAt(k - 1);
    }

    public void invertString(StringBuilder binaryString) {
        
        int length = binaryString.length() - 2;

        for (int i = length; i > - 1; i--) {
            if (binaryString.charAt(i) == '0')
                binaryString.append('1');
            else
                binaryString.append('0');
        }
    }

    // Optimal recursion solution
    // Time Complexity -> 0(n)
    // Space Complexity -> 0(1)
    public char findKthBit2(int n, int k) {
        k--;
        return findBit(n, k);
    }

    private char findBit(int n, int k) {
        if (k == 0)
            return '0';

        int length = (int) Math.pow(2, n) - 1;

        int mid = length / 2;


        if (k < mid)
            return findBit(n - 1, k);
        else if (k == mid)
            return '1';
        else
            return findBit(n - 1, length - k - 1 ) == '0' ? '1' : '0';
    }

    public char findKthBit3(int n, int k) {
        StringBuilder result = new StringBuilder("0");

        for (int i = 0; i < n; i++) {
            result.append('1');
            reverseInvert(result);

            if (result.length() >= k)
                break;
        }

        return result.charAt( k - 1);
    }

    private void reverseInvert(StringBuilder result) {
        int length = result.length();

        for (int i = length - 2; i > -1; i--) {
            if (result.charAt(i) == '0')
                result.append('1');
            else
                result.append('0');
        }


    }

    public char findKthBit4(int n, int k) {
        return bitOfBinaryString(n, k - 1);
    }

    private char bitOfBinaryString(int n , int k) {


        if (n == 1)
            return '0';

        int length = (int) Math.pow(2, n) - 1;
        int mid = length / 2;

        if (mid == k)
            return '1';
        else if (k < mid)
            return bitOfBinaryString(n - 1, k);
        else
            return invert(bitOfBinaryString(n - 1, length - k - 1));
    }

    private char invert(char ch) {
        return ch == '1' ? '0' : '1';
    }
}