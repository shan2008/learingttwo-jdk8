package com.yous.learningtwo.host.extend;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author syou
 * @date 2018/8/30.
 */
public class App {

    /**
     * 1.子类静态变量
     * 2.子类静态代码块
     * 3.父类构造函数
     * 4.子类成员变量初始化
     * 5.子类代码块
     * 5.子类构造函数
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        String url = "2E.jpg";
        System.out.println(url.lastIndexOf('.'));
        System.out.println(url.substring(url.lastIndexOf('.')));



    }
}
