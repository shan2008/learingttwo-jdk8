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



    public int getMaxSub(String str1,String str2){
        if(str2==null || str1==null){
            return 0;
        }

        int[][] dp=new int[str1.length()][str2.length()];
        int max=0;
        for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if(str1.charAt(i)==str2.charAt(j)){
                    if(i==0 && j==0){
                        dp[i][j]=1;
                    }else
                    {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    max=Math.max(max,dp[i][j]);
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }

}
