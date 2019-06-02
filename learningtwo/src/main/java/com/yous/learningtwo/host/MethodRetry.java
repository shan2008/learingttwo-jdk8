package com.yous.learningtwo.host;

import java.util.function.Function;

/**
 * @author syou
 * @date 2018/9/13.
 */
public class MethodRetry {


    public static <R> R retry(Function<Integer, R> method, Function<R, Boolean> assertFunc, int retryTime) {
        if (retryTime == 0) {
            return method.apply(retryTime);
        }

        R ret = method.apply(retryTime);
        if (assertFunc.apply(ret)) {
            return ret;
        }

        return retry(method, assertFunc, --retryTime);
    }



}
