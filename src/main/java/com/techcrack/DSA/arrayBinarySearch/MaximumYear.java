package com.techcrack.DSA.arrayBinarySearch;

//An 2D array is given Each element represents the birth and death of ith person
public class MaximumYear {

    //our Work is to find the maximum people alive in the ith person between birth and death-1
    public int maximumPopulation(int[][] logs) {
       int maxYear=logs[0][0];
       int minYear=logs[0][1];

       for(int[] k:logs){
           if(minYear>k[0])
               minYear=k[0];
           if(maxYear<k[1])
               maxYear=k[1];
       }

       int[] alive=new int[maxYear-minYear+1];

       for(int[] k:logs){
           alive[k[0]-minYear]++;
           alive[k[1]-minYear]--;
       }

       int maxIndex=0;

       for(int k=1;k<alive.length;k++){
           alive[k]+=alive[k-1];
       }

       for(int k=1;k<alive.length;k++){
           if(alive[maxIndex]<alive[k])
               maxIndex=k;
       }
        return  maxIndex+minYear;
    }
}
