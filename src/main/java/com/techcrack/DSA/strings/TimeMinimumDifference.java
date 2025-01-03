package com.techcrack.DSA.strings;

import java.util.List;

public class TimeMinimumDifference {
    public int findMinDifference1(List<String> timePoints) {
        int minimumTime = Integer.MAX_VALUE;
        
        for (int i = 0; i < timePoints.size(); i++) {
            
            String s = timePoints.get(i);
            int hour = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
            int minutes = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

            for (int j = 0; j < timePoints.size(); j++) {
                
                if (i == j) 
                    continue;

                String t = timePoints.get(i);
                final int localDifference = getLocalDifference(hour, minutes);

                if (localDifference < minimumTime)
                    minimumTime = localDifference;
            } 
        }

        return minimumTime;
    }

    private int getLocalDifference(int hour, int minutes) {
        int hour1 = hour;

        int localDifference = 0;

        if (hour1 < hour)
            localDifference = (hour - hour1) * 60 + (minutes - minutes);
        else {
            if (minutes < minutes)
                localDifference = minutes - minutes;
            else
                localDifference = minutes - minutes;
        }
        return localDifference;
    }

    // Bucket Method
    // Time Complexity -> O(n)
    // Space Complexity -> O(1440)
    public int findMinDifference5(List<String> timePoints) {
        boolean[] timeOccured = new boolean[1440]; // 24 * 60

        for (String time : timePoints) {
            String[] splitTime = time.split(":");

            int hour = Integer.parseInt(splitTime[0]) * 60;
            int minutes = Integer.parseInt(splitTime[1]);

            if (timeOccured[hour + minutes])
                return 0;

            timeOccured[hour + minutes] = true;
        }


        int minimumTime = Integer.MAX_VALUE;
        int previousTime = -1;
        int firstTime = -1;

        for (int i = 0; i < 1440; i++) {
            if (timeOccured[i]) {
                if (previousTime == -1) {
                    previousTime = i;
                    firstTime = i;
                }
                else {
                    int difference = i - previousTime;

                    if (difference < minimumTime)
                        minimumTime = difference;
                    previousTime = i;
                }
            }
        }

        return Math.min(1440 - previousTime + firstTime, minimumTime);

    }

    public int findMinDifference(List<String> timePoints) {
        boolean[] timeHolder = new boolean[1440];

        for (String time : timePoints) {
            String[] t = time.split(":");

            int hours = Integer.parseInt(t[0]);
            int minutes = hours * 60 +  Integer.parseInt(t[1]);

            if (timeHolder[minutes])
                return 0;

            timeHolder[minutes] = true;
        }

        return minimumDifference(timeHolder);
    }

    private int minimumDifference(boolean[] timeHolder) {
        int firstTime = -1;
        int previousTime = -1;


        int minimumTimeDifference = 1441;

        for (int i = 0; i < 1440; i++) {
            if (timeHolder[i]) {
                if (previousTime == -1) {
                    firstTime = i;
                    previousTime = i;
                }
                else  {
                    if (i - previousTime < minimumTimeDifference)
                        minimumTimeDifference = i - previousTime;

                    previousTime = i;
                }
            }
        }

        if (1440 - previousTime + firstTime < minimumTimeDifference)
            return 1440 - previousTime + firstTime;

        return minimumTimeDifference;
    }
}