package com.techcrack.DSA.ArraysAndBS;

public class HighestAltitude {

    /*
     *Given Array which a bike ride moves the
     * altitude move from and down
     */
    public int largestAltitude(int[] gain){
        int highestAltitude=0;
        int count=0;
        for(int k:gain){
            count+=k;
           if(count>highestAltitude)
               highestAltitude=count;
        }
        return highestAltitude;
    }
}
