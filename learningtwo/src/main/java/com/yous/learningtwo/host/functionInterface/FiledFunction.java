package com.yous.learningtwo.host.functionInterface;

/**
 * Created by syou on 2018/4/3.
 */
public interface FiledFunction<T,R> {
    R apply(T t);
}
