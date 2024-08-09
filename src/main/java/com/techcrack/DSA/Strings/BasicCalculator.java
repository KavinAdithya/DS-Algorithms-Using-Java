package com.techcrack.DSA.Strings;

import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        char operator = '+';
        int number =  0;
        Stack<Integer> numberStack = new Stack<>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch))
                number = (number * 10) + (ch - '0');
            
            if ((!Character.isDigit(ch) && ch != ' ') || i + 1 == length) {
                if (operator == '+')
                    numberStack.push(number);
                else if (operator == '-')
                    numberStack.push(-1 * number);
                else if (operator == '*')
                    numberStack.push(number * numberStack.pop());
                else
                    numberStack.push(numberStack.pop() / number);
                
                number = 0;
                operator = ch;
            }
            
        }

        int sum = 0;

        while (! numberStack.isEmpty()) 
            sum += numberStack.pop();
        
        return sum;
    }
}