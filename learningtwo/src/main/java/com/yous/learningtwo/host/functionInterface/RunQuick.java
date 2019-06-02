package com.yous.learningtwo.host.functionInterface;

/**
 * @author syou
 * @date 2019/5/7.
 */
@FunctionalInterface
public interface RunQuick<T> {

    T setLeg(T t);


    default String getLegs(T t) {
        return  "aaa";
    }
}
