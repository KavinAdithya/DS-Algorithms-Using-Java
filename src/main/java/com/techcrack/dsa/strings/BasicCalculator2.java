package com.techcrack.dsa.strings;

import java.util.Stack;

class BasicCalculator2 {
    public int calculate(String s) {
        boolean isFirst = findFirst(s);
        StringBuilder validExpression = findExpression(s);

        return evaluate(validExpression, isFirst, s);
    }

    private StringBuilder findExpression(String s) {
        StringBuilder validExpression = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (curChar == '(' || curChar == ')' || curChar == ' ')
                continue;
            
            if (! validExpression.isEmpty() && (curChar == '+' || curChar == '-') ){


                int length = validExpression.length() - 1;

                char prevChar= validExpression.charAt(length);
               
                if ( (prevChar == '+' && curChar == '-') || (prevChar == '-' && curChar == '+') ) {
                    validExpression.deleteCharAt(length);
                    validExpression.append('-');
                }
                else if (prevChar == '-' && curChar == '-') 
                    validExpression.append('+');
                else 
                    validExpression.append(curChar) ;

            }
            else 
                validExpression.append(curChar);
        }

        return validExpression;
    }

    private int evaluate(StringBuilder validExpression, boolean isFirst, String s) {
        int sum = 0;
        char prevOper = '+';
        int i = 0;

        int number = 0;

        if (validExpression.charAt(0) == '-'  && ++i != 0 && isFirst)
            prevOper = '-';
        
        for (; i < validExpression.length(); i++) {
            char curChar = validExpression.charAt(i);

            if (Character.isDigit(curChar)) 
                number = (number * 10) + (curChar - '0');

            if (curChar == '+' || curChar == '-' || i + 1 == validExpression.length()) {
                sum = prevOper == '+' ? sum + number : sum - number;
                number = 0;
                prevOper = curChar;
            }
            
        }

        return  s.charAt(0) == '-' &&  !isFirst ? sum * -1 : sum ;
    }

    private boolean findFirst(String s) {
        boolean isFirst = false;
        int index = 0;

        for (int i = 0; i  < s.length(); i++) {
            char curChar = s.charAt(i);

            if (i == 0 && curChar != '-')
                return isFirst;

            if (curChar == '(')
                isFirst = true;
            if (Character.isDigit(curChar))
                return !isFirst;      
            
        }

        return isFirst;
    }

    public int calculate1(String s) {
        Stack<Integer> unitSt = new Stack<Integer>();
        int sign = 1;
        int result = 0;
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (curChar == ' ')
                continue;
            else if (Character.isDigit(curChar))
                num = (num * 10) + (curChar - '0');
            else if (curChar == '+') {
                num *= sign;
                result += num;
                num = 0;
                sign = 1;
            }
            else if (curChar == '-') {
                num *= sign;
                result += num;
                num = 0;
                sign = -1;
            }
            else if (curChar == '(') {
                unitSt.push(result);
                unitSt.push(sign);
                sign = 1;
                result = 0;
            }
            else {
                num *= sign;
                result += num;
                result *= unitSt.pop();
                result += unitSt.pop();
                num = 0;
            }
        }

        result += sign * num;

        return result;

    }
}