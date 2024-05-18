package com.techcrack.DSA.Arrays;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int highProfit = 0;

        int lowSel = prices[0];

        for(int k = 1; k < prices.length; k++){

            if(lowSel > prices[k])
                lowSel = prices[k];

            int profit = prices[k] - lowSel;

            if(highProfit < profit)
                highProfit = profit;
        }

        return highProfit;
    }
}
