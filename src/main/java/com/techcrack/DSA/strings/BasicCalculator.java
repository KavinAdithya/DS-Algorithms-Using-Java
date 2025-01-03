package com.techcrack.DSA.strings;

import java.util.Stack;

class BasicCalculator {
    public int calculate2(String s) {
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
    public int calculate1(String s) {
        int length = s.length();

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        int digit = 0;

        int sPointer = 0;

        while (sPointer < length) {
            char ch = s.charAt(sPointer);

            if (Character.isDigit(ch))
                digit = (digit * 10) + (ch - '0');

            if ( ( ! Character.isDigit(ch) && ch != ' ') || sPointer + 1 == length ) {
                if ( ! operator.isEmpty() && operator.peek() == '-')
                    digit = digit * -1;

                operand.push(digit);
                digit = 0;

                if ( ! operator.isEmpty() && (operator.peek() == '/' || operator.peek() == '*') ) {
                    int b = operand.pop();
                    int a = operand.pop();

                    int c = operator.pop() == '*' ? a * b: a / b;

                    operand.push(c);
                }

                if (ch != ' ' && ! Character.isDigit(ch))
                    operator.push(ch);
            }
            sPointer++;
        }




        int sum = 0;

        while ( ! operand.isEmpty() )
            sum += operand.pop();


        return sum;
    }

    public int calculate3(String s) {
        int length = s.length();
        char operator = '+';

        int number = 0;

        Stack<Integer> operand = new Stack<>();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch))
                number = (number * 10) + (ch - '0');


            if ( ( ! Character.isDigit(ch) && ch != ' ') || i + 1 == length ) {
                if (operator == '+')
                    operand.push(number);
                else if (operator == '-')
                    operand.push(number * -1);
                else if (operator == '*')
                    operand.push(operand.pop() * number);
                else
                    operand.push(operand.pop() / number);

                number = 0;
                operator = ch;
            }
        }

        int result = 0;

        while ( ! operand.isEmpty() )
            result += operand.pop();

        return result;
    }
}