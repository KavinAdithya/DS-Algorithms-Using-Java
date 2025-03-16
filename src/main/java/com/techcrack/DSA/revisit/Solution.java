package com.techcrack.dsa.revisit;

class Solution {
    public static boolean parseBoolExpr(String expression) {
        return isValid(expression, 0);
    }

    private static boolean isValid(String expression, int index) {
        char ch = expression.charAt(index);

        if (ch == '!') 
            return ! isValid(expression, index + 2);
        
        if (ch == 'f')
            return false;
        
        if (ch == 't')
            return true;

        boolean isOr = false;

        if (ch == '|')
            isOr = true;
        
        int i = index + 2;

        while (i < expression.length() && expression.charAt(i) != ')') {
            if (isValid(expression, i) == isOr)
                return isOr;
            
            char curCh = expression.charAt(i);

            while (i < expression.length() && (curCh != 't' && curCh != 'f') && expression.charAt(i) != ')') i++;

            i += 2;
        }

        return !isOr;
    }

    public static void main(String[] args) {
        String e = "|(f,&(t,|(t,f),|(f,f)),f)";

        System.out.println(parseBoolExpr(e));
    }
}