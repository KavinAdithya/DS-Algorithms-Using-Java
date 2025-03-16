package com.techcrack.dsa.recursion;

class Solution {
    public boolean parseBoolExpr(String expression) {
        // Use an array of length 1 to hold the index by reference.
        int[] pos = new int[]{0};
        return evaluate(expression, pos);
    }


        private boolean evaluate(String expr, int[] pos) {
            char c = expr.charAt(pos[0]);

            // Base cases for literals.
            if (c == 't') {
                pos[0]++;
                return true;
            }
            if (c == 'f') {
                pos[0]++;
                return false;
            }

            // If the current char is an operator, skip it and the following '('
            if (c == '!') {
                pos[0]++; // skip '!'
                pos[0]++; // skip '('
                boolean result = !evaluate(expr, pos);
                pos[0]++; // skip ')'
                return result;
            }

            // For '&' or '|' operator.
            boolean isOr = (c == '|');
            pos[0]++; // skip the operator character
            pos[0]++; // skip '('

            // Initialize result: for OR, identity is false; for AND, identity is true.
            boolean result = isOr ? false : true;

            while (expr.charAt(pos[0]) != ')') {
                boolean subExpr = evaluate(expr, pos);
                if (isOr) {
                    result = result || subExpr;
                } else {
                    result = result && subExpr;
                }

                if (expr.charAt(pos[0]) == ',') {
                    pos[0]++;
                }
            }

            pos[0]++;
            return result;
        }



    public static void main(String[] args) {
        String expression = "&(!(&(&(&(&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t,t,f),&(&(&(t,t,f),|(f,f,t),|(f)),!(&(t)),!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t))))),&(t,t,f),&(!(!(&(|(f,f,t),&(&(f),&(!(t),&(f),|(f)),&(!(&(f)),&(t),|(f,f,t))),&(t)))),&(!(&(f)),&(t),|(f,f,t)),&(&(&(!(&(f)),|(t),&(!(t),!(|(f,f,t)),!(&(f)))),!(|(f,f,t)),&(t,t,f)),&(f),&(&(t),&(!(t),!(|(f,f,t)),!(&(f))),|(f,f,t))))),!(&(&(!(&(f)),&(t),|(f,f,t)),&(t),&(t,t,f))),&(f))),!(&(&(t),&(!(t),!(|(f,f,t)),!(&(f))),|(f,f,t))),!(!(!(&(t)))))";

        System.out.println(new Solution().parseBoolExpr(expression));
    }
}
