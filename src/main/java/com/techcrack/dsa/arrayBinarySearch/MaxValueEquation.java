package com.techcrack.dsa.arrayBinarySearch;

public class MaxValueEquation {

    public int findMaxValueOfEquation(int[][] points, int k) {
        int max=0;

        for(int d=1;d<points.length;d++){
            int x1=points[d-1][0];
            int x2=points[d][0];
            int x=((x1-x2)*-1);

            if(x<=k){
                int y1=points[d-1][1];
                int y2=points[d][1];

                int localValue=(y1+y2)+x;
                if(localValue>max)
                    max=localValue;
            }
        }

        return max;
    }
}
