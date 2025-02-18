package com.techcrack.dsa.strings;

class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        
        if (name == null || typed == null)
            return false;

        char[] nameArray = name.toCharArray();
        char[] typedArray = typed.toCharArray();

        int length = name.length();
        int typedLength = typed.length();

        int namePointer = 0;
        int typedPointer = 0;

        if (length > typedLength)
            return false;

        while (typedPointer < typedLength ) {
            char ch = namePointer >= length ? nameArray[length - 1] : nameArray[namePointer];
            char ch1 = typedArray[typedPointer];

            if (ch == ch1) {
                namePointer++;
                typedPointer++;
            }
            else if (namePointer != 0 && ch1 == typedArray[typedPointer - 1]) 
                typedPointer++;
            else
                return false;
        }


        return namePointer >= length;
    }
}