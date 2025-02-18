package com.techcrack.dsa.strings;

class FirstOccurence {
    public int strStr(String hayStack, String needle) {
        //return hayStack.indexOf(needle);

        if (needle == null || hayStack == null || needle.isEmpty() || hayStack.isEmpty())
            return -1;


        char needleFirstCharacter = needle.charAt(0);

        char[] hayStackArray = hayStack.toCharArray();
        char[] needleArray  = needle.toCharArray();

        int  needleLength = needleArray.length;

        for (int i = 0; i < hayStackArray.length; i++) {
            if (hayStackArray[i] == needleFirstCharacter && isSubstring(hayStackArray, needleArray, i, i + needleLength))
                return i;
        }

        return -1;
    }

    public boolean isSubstring(char[] hayStackArray, char[] needleArray, int startIndex, int endIndex) {
        if (endIndex > hayStackArray.length)
            return false;
        
        for (int i = startIndex; i < endIndex; i++) {
            if (hayStackArray[i] != needleArray[i - startIndex])
                return false;
        }

        return true;
    }
}