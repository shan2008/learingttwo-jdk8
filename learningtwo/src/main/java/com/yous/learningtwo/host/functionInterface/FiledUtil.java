package com.yous.learningtwo.host.functionInterface;

import java.lang.reflect.Field;
import java.util.Comparator;

/**
 * Created by syou on 2018/4/3.
 */
public class FiledUtil {

    public static <E> String[] getFileds(Class<E> clazz) {



        return getNames(clazz, new FiledProducer<Field[]>() {
            @Override
            public Field[] provide() {
                return clazz.getDeclaredFields();
            }
        }, new FiledFunction<Field, String>() {
            @Override
            public String apply(Field field) {
                return field == null ? null : field.getName();
            }
        });

    }


    private static String[] getNames(Class clazz, FiledProducer<Field[]> getFileds, FiledFunction<Field, String> getName) {
        Field[] fields = getFileds.provide();
        if (fields == null || fields.length == 0) {
            return null;
        }
        String[] fieldNames = new String[fields.length];
        int index = 0;
        for (Field field : fields) {
            String fieldName = getName.apply(field);
            fieldNames[index] =fieldName;
            index++;
        }
        return fieldNames;
    }
}
