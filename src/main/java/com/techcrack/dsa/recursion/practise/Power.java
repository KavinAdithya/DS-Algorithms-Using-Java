package com.techcrack.dsa.recursion.practise;

class Power {
    public double myPow1(double x, int n) {
        long value = n > 0 ? n : (long) n * -1;

        if (n < 0)
            return findPositive(1.0 / x, value);
        return findPositive(x, value);
    }

    private static double findPositive( double divideValue, long base) {
        double answer = 1.0;
        
        if (base == 1 )
            return divideValue;
        if (base == 0)
            return 1;
        answer = findPositive( divideValue, base / 2);

        answer *= answer;
        
        if (base % 2 == 1)
            answer *= divideValue;
        
        return answer ;
    }

    class Solution {
        public double myPow(double x, int n) {

            if (n == 0)
                return 1.0;

            if (x == 0)
                return 0;

            double answer = 1.0;



            long v = n;
            if ( n < 0) {
                v = (long) n * - 1;
                x =   1 / x;
            }

            double currentMultiplication = x;

            while (v > 0) {
                if (v % 2 == 1)
                    answer *= currentMultiplication;
                currentMultiplication *= currentMultiplication;
                v /= 2;
            }

            return answer;
        }
    }
}