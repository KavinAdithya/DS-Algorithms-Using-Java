package com.techcrack.DSA.arrayBinarySearch;

import java.util.List;
import java.util.ArrayList;

public class Candies {

    /*
     *Given an array. Each element in array represents a kid.And The value of element
     * is maximum number of candies
     * There are Three candies is extra available
     * On giving extra candie to each kid if they is greatest among them then they are true
     * else the false
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        //List for Storing the result of boolean
        List<Boolean> list=new ArrayList<>();

        //Initially we assume the 0 index has maximum value
        int maxCandieIndex=0;

        //Finding any  other greater candie
        for(int k=1;k<candies.length;k++){
            if(candies[maxCandieIndex]<candies[k])
                maxCandieIndex=k;
        }


        //Finding they are greatest when they have given n extra candies

        for(int k=0;k<candies.length;k++){
            if(candies[maxCandieIndex]<=(candies[k]+extraCandies))
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }
}
