package com.yous.learningtwo.host.algorithm.StringAlg;

public class longestPalindromeSubseq {


    /**
     * 516. 最长回文子序列
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int n = s.length();
        /**
         * 表示从第i到第j字符串 回文长度
         */
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int j = n - 1; j >= 0; j--) {
            for (int k = j + 1; k < n; k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    dp[j][k] = dp[j + 1][k - 1] + 2;
                } else {
                    dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
