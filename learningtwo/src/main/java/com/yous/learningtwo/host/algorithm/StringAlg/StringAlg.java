package com.yous.learningtwo.host.algorithm.StringAlg;

import java.util.HashSet;
import java.util.List;

/**
 * @author syou
 * @date 2019/12/3.
 */
public class StringAlg {

    /**
     *  dp[i,j)，表示从 s 的第 i 个字符开始，到第 j 个字符的前一个结束的字符串是否能由 wordDict 构成
     *  用 dp[i] 表示字符串 s[0,i) 能否由 wordDict 构成。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set =new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
