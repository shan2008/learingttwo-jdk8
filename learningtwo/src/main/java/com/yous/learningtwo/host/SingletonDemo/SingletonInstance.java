package com.yous.learningtwo.host.SingletonDemo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author syou
 * @date 2019/7/7.
 */
public class SingletonInstance implements Serializable {
    private static class MyInstance {
        private static final SingletonInstance instance = new SingletonInstance();
    }


    public static SingletonInstance getInstance() {
        return MyInstance.instance;
    }


    private void readObject(ObjectInputStream in) {
        System.out.println("readObject......");
    }

    private void writeObject(ObjectOutputStream out) {
        System.out.println("writeObject......");
    }

    protected Object readResolve() {
        System.out.println("readResolve...");
        return MyInstance.instance;
    }

}
