package com.yous.learningtwo.host.serialize;

import java.io.*;

/**
 * @author syou
 * @date 2018/8/1.
 */
public class App {

    public static void main(String[] args) throws Exception {
        try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("D:\\Users\\syou\\Desktop\\test\\out.obj"))) {
            outputStream.writeObject(new Man());
        }catch (Exception e){
            System.out.println(e);
        }

        try(ObjectInputStream  inputStream = new ObjectInputStream(new FileInputStream("D:\\Users\\syou\\Desktop\\test\\out.obj"))) {
            Person p = (Person) inputStream.readObject();

            System.out.println(p);
        }
    }
}
