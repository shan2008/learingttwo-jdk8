package com.yous.learningtwo.host.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author syou
 * @date 2018/9/13.
 */
public class CglibProxy {
    private Object obj;

    public CglibProxy(Object obj) {
        this.obj = obj;
    }


    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(method.getName());
                method.invoke(obj, objects);
                return o;
            }
        });


        return enhancer.create();
    }

}
