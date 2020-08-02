package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class CoinChange {

    @Test
    public void test() {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, 11));

    }

    public int coinChange(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length <= 0) {
            return 0;
        }
        // 初始化dp[i],表示i元钱需要的做小硬币
        // dp[i+1]=dp[i]+1
        //
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        // amount元最多只能有amount个
        return (dp[amount] == amount + 1) ?
                -1 : dp[amount];
    }


}
