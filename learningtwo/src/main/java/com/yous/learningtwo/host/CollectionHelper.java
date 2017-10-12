package com.yous.learningtwo.host;

import java.util.List;

/**
 * Created by syou on 2017/9/16.
 */
public class CollectionHelper {
    public static <T> T filter(T t,CollectionHandler<T> o){
       return o.filter(t);
    }


    public static String getOperator(){
        return "operator";
    }
}
