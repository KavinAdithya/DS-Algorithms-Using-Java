package com.techcrack.DSA.Strings;

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
    public char findKthBit(int n, int k) {
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
}