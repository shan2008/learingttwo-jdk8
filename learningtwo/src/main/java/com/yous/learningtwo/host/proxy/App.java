package com.yous.learningtwo.host.proxy;

import java.lang.reflect.Proxy;

/**
 * @author syou
 * @date 2018/9/13.
 */
public class App {

    public static void main(String[] args) {
        Car car = new SuperCar();
        System.out.println(car);
        Car proxy = (Car) new JdkProxy(car).getProxy();
        System.out.println(proxy instanceof Proxy);
        System.out.println(proxy instanceof Car);
        proxy.price();
        System.out.println("************************");
        System.out.println(car);
        Car proxy2 = (SuperCar) new CglibProxy(car).getProxy();
        proxy2.price();
        
    }
}
