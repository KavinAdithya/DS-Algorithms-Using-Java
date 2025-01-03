 package com.techcrack.DSA.strings;

class ValidNumber {
    public boolean isNumber(String s) {
        boolean digit = false;
        boolean exponential = false;
        boolean dot = false;

        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9')
                digit = true;
            
            else if (ch == '.') {
                
                if (dot || exponential)
                    return false;
                
                dot = true;
            }
            else if (ch == 'e' || ch == 'E') {
                if (exponential || !digit)
                    return false;
                
                digit = false;
                exponential = true;
            }
            else if (ch == '+' || ch == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false; 
            }
            else
                return false;
            
            i++;
        }

        return digit;
    }
}