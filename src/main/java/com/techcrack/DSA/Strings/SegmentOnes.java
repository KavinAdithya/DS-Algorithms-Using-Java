package com.techcrack.DSA.Strings;

class SegmentOnes {

    // Time Complexity -> O(n)
    // Space Complexity -> O(1)
    public boolean checkOnesSegment(String s) {
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
}