package com.yous.learningtwo.host.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author syou
 * @date 2018/9/13.
 */
public class JdkProxy {

    private Object obj;

    public JdkProxy(Object obj) {
        this.obj = obj;
    }


    public Object getProxy() {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName());
                        method.invoke(obj, args);
                        return proxy;
                    }
                });
    }
}
