package com.yous.learningtwo.host.SingletonDemo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author syou
 * @date 2019/7/7.
 */
public class SingletonInstance implements Serializable {
    private int i;
    private String name;
    private SingletonInstance(int i,String name){
        this.i=i;
        this.name=name;

    }
    private static class MyInstance {
        private static final SingletonInstance instance = new SingletonInstance(1,"shan");
    }


    public static SingletonInstance getInstance() {
        return MyInstance.instance;
    }


    private void readObject(ObjectInputStream in) {
       try {
           int  s=in.readInt();
           System.out.println("readObject......");
       }catch (Exception e){
           //
       }

    }

    private void writeObject(ObjectOutputStream out) {
        try {
            out.writeInt(2);
            System.out.println("writeObject......");
        }catch (Exception e){

        }

    }

    protected Object readResolve() {
        System.out.println("readResolve...");
        return MyInstance.instance;
    }

}
