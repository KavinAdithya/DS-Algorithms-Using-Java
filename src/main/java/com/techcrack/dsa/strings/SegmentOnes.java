package com.techcrack.dsa.strings;

class SegmentOnes {

    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
    public boolean checkOnesSegment3(String s) {
        int segmentOnes = 0;
        int segmentSum = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '1')
                segmentSum++;
            else
                if (segmentSum != 0) {
                    segmentOnes++;
                    segmentSum = 0;

                    if (segmentOnes > 1)
                        return false;
                }
        }

        if (segmentSum != 0)
            segmentOnes++;
        
        return segmentOnes < 2;
    }


    // Time Complexity -> 0(n)
    // Space Complexity -> 0(1)
    public boolean checkOnesSegment1(String s) {

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1')
                return false;
        }

        return true;
    }


    public boolean checkOnesSegment2(String s) {
        int segmentOnes = 1;
        int segmentSum = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char ch = s.charAt(i);

            if (ch == '0' && s.charAt( i + 1) == '1')
                segmentOnes++;
        }

        return segmentOnes < 2;
    }

    public boolean checkOnesSegment4(String s) {
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0')
                return false;
        }

        return true;
    }
}