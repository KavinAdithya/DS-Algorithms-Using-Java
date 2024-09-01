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
}