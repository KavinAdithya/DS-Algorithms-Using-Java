package com.techcrack.DSA.Strings;

class EqualSubstrings {
    // Two Pointer && Sliding window
    // Time Complexity -> 0(n)
    // Space Complexity -> 0(1)
    public int equalSubstring3(String s, String t, int maxCost) {
        int leftPointer = 0;
        int rightPointer = 0;

        int result = 0;
        int currentMaximum = 0;

        while (rightPointer < s.length()) {
            currentMaximum += Math.abs(s.charAt(rightPointer) - t.charAt(rightPointer));

            while ( currentMaximum > maxCost) {
                currentMaximum -= Math.abs(s.charAt(leftPointer) - t.charAt(leftPointer));
                leftPointer++;
            }

            result = Math.max(result, rightPointer - leftPointer + 1);
            rightPointer++;
        }

        return result;
    }

    // Brute Force
    // Time Complexity -> O(n ^ 2)
    // Space Complexity -> 0(1)

    public int equalSubstring1(String s, String t, int maxCost) {
        int maximumLength = 0;
        int length = s.length();


        for (int i = 0; i < length; i++) {
            int sum = 0;

            for (int j = i; j < length; j++) {
                sum += (int) (Math.abs(s.charAt(j) - t.charAt(j)));

                if (sum <= maxCost && j - i + 1 > maximumLength)
                    maximumLength = j - i + 1;
                if (sum > maxCost)
                    break;



            }
        }

        return maximumLength;

    }

    // Binary search && two Pointer
    // Time complexity -> 0(nlog(n))
    // Space Complexity -> 0(n)
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 1;
        int end = s.length();

        int maximumCostLength = 0;

        int[] cost = findCost(s, t);



        while (start <= end) {
            int mid = (start + end) / 2;

            if (isSubstring( cost, maxCost, mid)) {
                maximumCostLength = mid ;
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        return maximumCostLength;
    }

    public int[] findCost(String s, String t) {
        int length = s.length();

        int[] cost = new int[length];

        for (int i = 0; i < length; i++)
            cost[i] = (int) Math.abs(s.charAt(i) - t.charAt(i));

        return cost;
    }

    public boolean isSubstring(int[] cost, int maxCost, int maxLength) {
        int length = cost.length;

        int i = 0;
        int j = maxLength;
        int costRequired = 0;

        for (int k = 0; k < maxLength; k++)
            costRequired += cost[k];

        if (costRequired <= maxCost)
            return true;
        while (j < length) {
            costRequired += cost[j];

            while (i < j && costRequired > maxCost) {
                costRequired -= cost[i];
                i++;
            }

            if (maxCost >= costRequired && j - i + 1 == maxLength)
                return true;
            j++;
        }

        return false;
    }
}