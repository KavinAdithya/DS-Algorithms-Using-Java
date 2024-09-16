package com.techcrack.DSA.Strings;

class StringToIntegerAtoi {
    public int myAtoi(String s) {
        boolean isNegative = false;
        boolean isVisitedDigit = false;
        boolean isVisitedSign = false;
    

        long result = 0;


        for (char ch : s.toCharArray()) {
            if (ch == ' ' && !isVisitedDigit && !isVisitedSign)
                continue;
            else if ((ch == '-' || ch == '+') && !isVisitedSign && !isVisitedDigit) {
                isVisitedSign = true;
                if (ch == '-')
                    isNegative = true;
            }
            else if (ch == '0' && !isVisitedDigit) 
                isVisitedDigit = true;
            else if (Character.isDigit(ch)) {
                result = result * 10 + (ch - '0');
                isVisitedDigit = true;
            }
            else
                break;

            if (result > (long) Integer.MAX_VALUE && !isNegative)
                return Integer.MAX_VALUE;
            else if (isNegative && result * -1 < (long) Integer.MIN_VALUE  )
                return Integer.MIN_VALUE;
        }

        if (isNegative)
            result *= -1;
        
        if (result < (long)Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (result > (long)Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (int) result;
    }
}