package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

public class PrintNNumber {

    @Test
    public void test(){
        int [] re=printNumber(1);
        System.out.println(re);
    }


    public int[] printNumber(int n) {
        int max = 1;
        while (n-- > 0) {
            max = max * 10;
        }

        int [] result=new int[max-1];
        int j=0;
        for (int i=1;i<max;i++){
            result[j++]=i;
        }
        return result;
    }

}
