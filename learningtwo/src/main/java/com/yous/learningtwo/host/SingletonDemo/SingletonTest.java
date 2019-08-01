package com.yous.learningtwo.host.SingletonDemo;

import org.junit.Test;

import java.io.*;

/**
 * @author syou
 * @date 2019/7/7.
 */
public class SingletonTest {


    @Test
    public void Test() throws Exception {
        SingletonInstance instance = SingletonInstance.getInstance();
        System.out.println("before:"+instance.hashCode());
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("./test.txt")))) {
            outputStream.writeObject(instance);
        }


        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("./test.txt")))) {
            instance = (SingletonInstance) inputStream.readObject();
            System.out.println("after:"+instance.hashCode());
        }

    }
}
