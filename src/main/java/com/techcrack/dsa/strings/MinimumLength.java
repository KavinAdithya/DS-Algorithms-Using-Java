package com.techcrack.dsa.strings;

class MinimumLength {
    public int minimumLength(String s) {
        int prefixPointer = 0;
        int length = s.length();

        char[] sArray = s.toCharArray();
       
        int suffixPointer = length - 1;

        while (prefixPointer < suffixPointer) {
            
            if (sArray[prefixPointer] == sArray[suffixPointer]) {
                prefixPointer++;

                while (prefixPointer < suffixPointer && sArray[prefixPointer] == sArray[prefixPointer - 1])
                    prefixPointer++;
                

                suffixPointer--;

                while (prefixPointer < suffixPointer && sArray[suffixPointer] == sArray[suffixPointer + 1])
                    suffixPointer--;

            }else 
                break;
        }

        if (prefixPointer  > suffixPointer)
            return 0;
        
        return suffixPointer - prefixPointer + 1;
    }
}