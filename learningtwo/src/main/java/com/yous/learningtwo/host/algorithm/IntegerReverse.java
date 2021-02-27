package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

public class IntegerReverse {


    @Test
    public void test(){
        System.out.println(reverse(-123));
    }

    /**
     * 整数翻转
     * @param x
     * @return
     */
    public int reverse(int x){
       long n=0;
       while (x!=0){
           n=n*10+x%10;
           x=x/10;
       }

       return (int)n==n?(int)n:0;
    }


}
