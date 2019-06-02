package com.yous.learningtwo.host.Demo;

import com.yous.learningtwo.host.dto.SmallCarDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author syou
 * @date 2018/4/28.
 */
public class Demo13 {
    public static void main(String[] args) {
        List<SmallCarDTO> small = new ArrayList<>();
        SmallCarDTO c1 = new SmallCarDTO();
        c1.setNo(3);
        c1.setBrand("国产");
        c1.setId(1111);
        small.add(c1);

        SmallCarDTO c2 = new SmallCarDTO();
        c2.setNo(2);
        c2.setBrand("国产");
        c2.setId(1112);
        small.add(c2);


    }

    private static <T extends Enum<T>> int getTheme2BitVal(T[] type) {


        return 0;
    }

    private static <T extends Enum<T>> T convert(Class<T> clazz) {
      Object[] objects= clazz.getEnumConstants();
        for (Object o:objects){
            System.out.println();
        }


        return  null;
    }


}
