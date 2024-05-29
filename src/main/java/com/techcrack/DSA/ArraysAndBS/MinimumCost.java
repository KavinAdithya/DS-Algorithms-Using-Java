package com.techcrack.DSA.ArraysAndBS;

public class MinimumCost {
    //Minimum cost to move all the elements in a single position
    public int minCostToMoveChips(int[] position) {
        int odd=0,even=0;
        for(int k:position){
            if((k%2)==0)even++;
            else odd++;
        }

        if(odd==position.length||even==position.length)
            return 0;
        return Math.min(odd, even);
    }
}
