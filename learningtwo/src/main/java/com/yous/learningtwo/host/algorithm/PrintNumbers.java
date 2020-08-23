package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.Arrays;

public class PrintNumbers {

    @Test
    public void Test(){

        int[] re=printNumbers(3);

        Arrays.stream(re)
                .boxed().forEach(x->System.out.println(x));

    }

    public int[] printNumbers(int n) {

        int max=(int) Math.pow(10,n)-1;
        int [] result=new int[max+1];
        int j=0;
        for (int i=0;i<=max;i++){
            result[j++]=i;
        }
        return result;
    }

}
