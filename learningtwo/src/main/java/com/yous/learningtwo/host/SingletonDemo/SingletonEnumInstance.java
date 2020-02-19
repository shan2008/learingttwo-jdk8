package com.yous.learningtwo.host.SingletonDemo;


/**
 * @author syou
 * @date 2019/7/7.
 */
public enum SingletonEnumInstance {
    INSTANCEFACTROY;
    private MyInstance instance = null;

    private SingletonEnumInstance() {
        instance = new MyInstance();
    }


    public MyInstance instance() {
        return instance;
    }

    public static MyInstance getInstance() {
        return SingletonEnumInstance.INSTANCEFACTROY.instance();
    }
}
