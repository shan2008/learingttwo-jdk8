package com.yous.learningtwo.host.SingletonDemo;


/**
 * @author syou
 * @date 2019/7/7.
 */
public enum SingletonEnumInstance {
    INSTANCEFACTROY;
    private MyInstance instance = null;

    SingletonEnumInstance() {
        instance = new MyInstance();
    }


    public static MyInstance getInstance() {
        return INSTANCEFACTROY.instance;
    }
}
