package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

public class MyPow {

    @Test
    public void test() {
        System.out.println(myPow(2, -2147483648));
    }

    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        return n > 0 ? pow(x, n) : pow(1 / x, -n);
    }


    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double result = pow(x, n /2);
        result *= result;
        if ((n & 1) == 1) {
            result *= x;
        }

        return result;
    }
}
