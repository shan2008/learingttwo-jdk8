package com.yous.learningtwo.host.algorithm;

public class MaxProfit {

    //dp[i][k][j] 表示第i天，k能交易次数，j持有和未持有股票,表示当前利润

    //dp[i][k][0]=max(dp[i-1][k][0],dp[i-1][k][1]+prices[i])
    //dp[i][k][1]=max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i])

    //dp[i][0][1]=不存在，dp[-1][k][1]不存在
    //当k=1;
     /*dp[i][1][0]=max(dp[i-1][1][0],dp[i-1][1][1]+prices[i]);

     dp[i][1][1]=max(dp[i-1][1][1],dp[i-1][0][0]-prices[i]);
                = max(dp[i-1][1],-prices[i]);
                = max(dp[i-1][1],-prices[i]);

    dp[i][1][0]=max(dp[i-1][0],dp[i-1][1]+prices[i]);*/


    public int maxProfit3(int[] prices) {
        int d_i_0 = 0, d_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            d_i_0 = Math.max(d_i_0, d_i_1 + prices[i]);
            d_i_1 = Math.max(d_i_1, -prices[i]);
        }

        return d_i_0;
    }


    public int maxProfit(int[] prices) {
        int profit = 0;
        int minCost = prices[0];

        // [7,1,5,3,6,4]
        for (int i = 1; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);
            profit = Math.max(profit, prices[i] - minCost);
        }

        return profit;
    }


    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length <= 0) {
            return -1;
        }

        int minCost = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minCost);
        }

        return maxProfit;
    }
}
