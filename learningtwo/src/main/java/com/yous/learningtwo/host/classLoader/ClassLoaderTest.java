package com.yous.learningtwo.host.classLoader;

import org.apache.poi.ss.formula.functions.T;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader clazzLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String clazzName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(clazzName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        String classPath="com.yous.learningtwo.host.classLoader.ClassLoaderTest";
        Class class1=clazzLoader.loadClass(classPath);

        Object object=class1.newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.yous.learningtwo.host.classLoader.ClassLoaderTest);


    }
}
