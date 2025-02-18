package com.techcrack.dsa.strings;

class MultiplyStrings {
    public String multiply1(String num1, String num2) {
        long number1 = 0;

        for (char ch : num1.toCharArray()) 
            number1 = (number1 * 10) + (ch - '0');
        
        long number2 = 0;
        for (char ch : num2.toCharArray())
            number2 = (number2 * 10) + (ch - '0');

        return String.valueOf(number1 * number2);
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        char[] number1 = num1.toCharArray();
        char[] number2 = num2.toCharArray();

        int length1 = number1.length;
        int length2 = number2.length;

        int[] result = new int[length1 + length2];



        for (int i = length2 - 1; i > -1; i--) {
            for (int j = length1 - 1; j > -1; j--) {
                int value = (number1[j] - '0') * (number2[i] - '0');

                result[j + i + 1] += value;
                result[j + i] += result[j + i + 1] / 10;
                result[j + i + 1] %= 10;
            }

        }

        StringBuilder resultString = new StringBuilder();
        boolean satisfyString = true;

        for (int r : result) {
            if (satisfyString && r != 0)
                satisfyString = false;
            if (!satisfyString)
                resultString.append(r);
        }


        return resultString.toString();

    }

    public String multiply2(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();

        int[] num1Digit = stringToArray(num1, length1);
        int[] num2Digit = stringToArray(num2, length2);

        int[] result = new int[length1 + length2];

        for (int i = length2 - 1; i > -1; i--) {

            for (int j = length1 - 1 ; j > -1; j--) {
                result[i + j + 1] += num1Digit[j] * num2Digit[i];

                result[i + j] += (result[i + j + 1] / 10);

                result[i + j + 1] %= 10;
            }
        }

        StringBuilder resultString = new StringBuilder();
        boolean first = false;

        for (int i = 0; i < result.length; i++) {
            if ( ! first && result[i] != 0)
                first = true;
            if (first)
                resultString.append("" + result[i]);
        }



        return resultString.isEmpty() ? "0" : resultString.toString();
    }

    public int[] stringToArray(String s, int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++)
            array[i] = s.charAt(i) - '0';

        return  array;
    }

}