package com.yous.learningtwo.host.functionInterface;

import java.util.Optional;

/**
 * @author syou
 * @date 2018/6/4.
 */
public class Demo15 {
    public static void main(String[] args) {

        Integer id=new Integer(6);
        System.out.println(Optional.of(id).orElse(0));
    }
}
