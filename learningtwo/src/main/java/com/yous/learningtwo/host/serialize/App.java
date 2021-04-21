package com.yous.learningtwo.host.serialize;

import java.io.*;
import java.util.HashSet;

/**
 * @author syou
 * @date 2018/8/1.
 */
public class App {

    public static void main(String[] args) throws Exception {

        Man man=new Man();
        man.setSex(true);

        Person person=new Person("youshan",1);
        man.setPerson(person);

        try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("out.obj"))) {
            outputStream.writeObject(man);
            outputStream.reset();
            man.setSex(false);
            outputStream.writeObject(man);
        }catch (Exception e){
            System.out.println(e);
        }

        try(ObjectInputStream  inputStream = new ObjectInputStream(new FileInputStream("out.obj"))) {
            Man p = (Man) inputStream.readObject();
            Man p1 = (Man) inputStream.readObject();
            System.out.println(p);
        }

    }
}
