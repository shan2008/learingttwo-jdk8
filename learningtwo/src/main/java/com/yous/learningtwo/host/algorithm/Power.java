package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

public class Power {

    @Test
    public void test() {

        System.out.println(myPow(2, -2));

    }


    /**
     * N次方
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, long n) {
        long N=n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return x;
        }
        double result = myPow(x, N>>1);
        result *= result;
        if ((N & 1) == 1) {
            result = result * x;
        }

        return result;
    }
}
