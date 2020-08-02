package com.yous.learningtwo.host.adapter;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

public class App {


    public static void main(String[] args) {


        Target target = new SomeAdapter();
        System.out.println(target.method2());

    }
}
