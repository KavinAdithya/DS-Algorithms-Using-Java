package com.techcrack.DSA.Strings;

class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isPatternMatches(s, p, s.length() - 1, p.length() - 1);        
    }


    private boolean isPatternMatches(String s, String p, int i, int j) {
        
        if (i < 0 && j < 0)
            return true;
        
        if (j < 0)
            return false;
        
         char ch1 = p.charAt(j);
        
        if (i < 0) {
        
            if (ch1 == '*')
                return isPatternMatches(s, p, i, j - 2);
            else
                return false;
        }
        char ch = s.charAt(i);

        if (ch1 == '*') {

            boolean res = false;
            if (p.charAt(j - 1) == ch || p.charAt(j - 1) == '.')
                res = res || isPatternMatches(s, p, i - 1, j);
            return res || isPatternMatches(s, p, i, j - 2);

        }


        if (ch1 == '.' || ch == ch1)
            return isPatternMatches(s, p, i - 1, j - 1);
        
        return false;        
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            return isPatternValid(s, p, 0, 0);
        }


        private boolean isPatternValid(String s, String p, int i, int j) {
            int length1 = s.length();
            int length2 = p.length();

            if (i >= length1 && j >= length2)
                return true;

            if (j >= length2)
                return false;

            char ch = p.charAt(j);

            if (i  >= length1) {
                if (j + 1 < length2 && p.charAt(j + 1) == '*' )
                    return isPatternValid(s, p, i, j + 2);
                else
                    return false;
            }

            char ch1 = s.charAt(i);

            if (j + 1 < length2 && p.charAt(j + 1) == '*') {

                boolean result = false;
                if (ch == ch1 || ch == '.')
                    result = result || isPatternValid(s, p, i + 1, j);
                return result || isPatternValid(s, p, i, j + 2);
            }

            if (ch == ch1 || ch == '.')
                return isPatternValid(s, p, i + 1, j + 1);
            return false;
        }
    }
}