package com.techcrack.DSA.ArrayBinarySearch;

public class SellStocks {

    //Brute Force
    public int maxProfit1(int[] prices) {
        int maxProfit = 0;

        for(int k = 0; k < prices.length; k++){

            for(int v = k + 1; v < prices.length; v++){

                if(prices[v] - prices[k] > maxProfit)
                    maxProfit = prices[v] - prices[k];
            }
        }

        return maxProfit;
    }
}
