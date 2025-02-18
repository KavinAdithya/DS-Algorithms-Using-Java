package com.techcrack.dsa.strings;

class LengthOfLastWord {
    public int lengthOfLastWord1(String s) {
        int count = 0;
        int j = s.length() - 1;
        char curChar = '!';
        boolean isInitChar = false;

        do {    

            curChar = s.charAt(j);

            if (count == 0 && curChar != ' ') 
                isInitChar = true;
            
            if (isInitChar)
                count++;
            j--;

        }while (j > -1  && !(count != 0 && s.charAt(j) == ' ') );

        return count;
    }


    public int lengthOfLastWord(String s) {
        int count = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            char curChar = s.charAt(i);

            if (curChar == ' ' && count == 0)
                continue;
            else if (curChar !=  ' ')
                count++;
            else
                return count;
        }

        return count;
    }
}