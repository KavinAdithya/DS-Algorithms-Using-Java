package com.techcrack.DSA.Strings;

import java.util.Stack;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> storedParentheses = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                storedParentheses.push(ch);
            else {
                if (storedParentheses.isEmpty())
                    return false;
                char top = storedParentheses.pop();
                
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '['))
                    return false;
            }
        }


        return storedParentheses.isEmpty();
    }
}