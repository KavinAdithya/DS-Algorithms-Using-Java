package com.techcrack.dsa.strings;

public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        var key = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        var ans = new StringBuilder();
        int pointer = key.length - 1;

        while (num > 0) {
            while (pointer >= 0 && key[pointer] > num)
                pointer--;
            
            if (pointer < 0)
                break;

            ans.append(symbol[pointer]);

            num -= key[pointer];
        }

        return ans.toString();
    }
}