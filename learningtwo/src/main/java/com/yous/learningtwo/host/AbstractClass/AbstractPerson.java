package com.yous.learningtwo.host.AbstractClass;

import javax.annotation.PostConstruct;

/**
 * @author syou
 * @date 2019/5/13.
 */
public abstract class AbstractPerson {

    public AbstractPerson(){
        System.out.println("AbstractPerson...");
    }

    public abstract String getName();


    public  int getId(){
        return 123;
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }
}
