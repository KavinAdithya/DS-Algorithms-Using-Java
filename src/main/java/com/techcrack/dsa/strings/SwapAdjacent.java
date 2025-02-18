package com.techcrack.dsa.strings;

class SwapAdjacent {
    public boolean canTransform1(String start, String end) {
        int startPointer = 0;
        int endPointer = 0;

        int length = start.length();

        if (! start.replace("X", "").equals(end.replace("X","")))
            return false;

        while (startPointer < length && endPointer < length) {
            while (startPointer < length && start.charAt(startPointer) == 'X')
                startPointer++;
            while (endPointer < length && end.charAt(endPointer) == 'X')
                endPointer++;
            
            if (startPointer == length && endPointer == length)
                return true;
            
            if (startPointer == length || endPointer == length)
                return false;
            
            if (start.charAt(startPointer) == 'R' && startPointer > endPointer)
                return false;
            
            if (start.charAt(startPointer) == 'L' && startPointer < endPointer)
                return false;

            startPointer++;
            endPointer++;
        }

        return true;
    }


    public boolean canTransform(String start, String end) {
        int startPointer = 0;
        int endPointer = 0;

        int length = start.length();

        while (startPointer < length || endPointer < length) {

            while (startPointer < length && start.charAt(startPointer) == 'X')
                startPointer++;

            while (endPointer < length && end.charAt(endPointer) == 'X')
                endPointer++;

            if (startPointer == length && endPointer == length)
                return  true;
            else if (startPointer == length || endPointer == length)
                return false;
            else if (start.charAt(startPointer) != end.charAt(endPointer))
                return false;
            else if (start.charAt(startPointer) == 'R' && startPointer > endPointer)
                return false;
            else if (start.charAt(startPointer) == 'L' && startPointer < endPointer)
                return false;


            startPointer++;
            endPointer++;
        }

        return true;
    }
}