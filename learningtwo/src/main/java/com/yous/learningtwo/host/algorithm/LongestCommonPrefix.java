package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

public class LongestCommonPrefix {

    @Test
    public void test(){
        String[] strs={"leetc","leetlde","leet","lee"};
        System.out.println(longestCommonPrefix(strs));
    }


    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length<=0){
            return "";
        }
        String prefix=strs[0];
        for (int i=1;i<strs.length;i++){
            prefix=calLongestPrefix(prefix,strs[i]);
            if(prefix==null || prefix.length()<=0){
                break;
            }
        }

        return prefix;
    }


    public String calLongestPrefix(String prefix,String str){
        int min=Math.min(prefix.length(),str.length());
        int index=0;
        while (index<min && prefix.charAt(index)==str.charAt(index)){
            index++;
        }

        return prefix.substring(0,index);
    }
}
