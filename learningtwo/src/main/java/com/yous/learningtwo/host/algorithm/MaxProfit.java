package com.yous.learningtwo.host.algorithm;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minCost = prices[0];

        // [7,1,5,3,6,4]
        for (int i = 1; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);
            profit=Math.max(profit,prices[i]-minCost);
        }

        return profit;
    }
}
