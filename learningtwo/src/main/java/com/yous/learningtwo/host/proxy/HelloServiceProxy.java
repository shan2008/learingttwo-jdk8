package com.yous.learningtwo.host.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author syou
 * @date 2019/5/9.
 */
public class HelloServiceProxy implements InvocationHandler {
    private Object target;


    public Object bind(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前
        Object result = method.invoke(target, args);
        // 后


        return null;
    }
}
