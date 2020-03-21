package com.yous.learningtwo.host.algorithm.StringAlg;

import org.junit.Test;

import java.util.Arrays;

public class StringApp {


    /**
     * 最长不重复儿子串
     */
    @Test
    public void NoRepeatSubStr(){
        int max=new NoRepeatSubStr().lengthOfLongestSubstring("abba");
        System.out.println(max);

        String maxSub=new NoRepeatSubStr().maxOfLongestSubstring(" ");
        System.out.println(maxSub+":"+maxSub.length());

        lengthOfLongestSubstring(" ");
    }


    /**
     * 2
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        if(s==""){
            return 1;
        }

        String result = "";
        String temp = "";
        for (String c : Arrays.asList(s.split(""))) {
            if (!temp.contains(c)) {
                temp = temp.concat(c);
            } else {
                if(temp.length()>=result.length()){
                    result=temp;
                }
                temp=temp.substring(temp.indexOf(c)+1).concat(c);
            }
        }


        if(temp.length()>result.length()){
            System.out.println(temp);
            return temp.length();
        }

        System.out.println(result);

        return result.length();

    }
}
