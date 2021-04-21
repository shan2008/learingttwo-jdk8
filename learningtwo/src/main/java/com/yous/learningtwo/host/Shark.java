package com.yous.learningtwo.host;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author syou
 * @date 2019/11/15.
 */
public class Shark {

    public static void main(String[] args) {

        Map<String, List<String>> map = new HashMap<>();

        List<String> a1 = new ArrayList<>(Arrays.asList("49", "45", "51", "55"));
        List<String> a2 = new ArrayList<>(Arrays.asList("4", "5", "1", "0"));
        map.put("1", a1);


        List<List<String>> aa = Arrays.asList(a1, a2);

        aa.stream().flatMap(Collection::stream)
                .collect(Collectors.toList());

      //  System.out.println(string1);

        String string = Optional.ofNullable(map)
                .map(x -> map.get("1"))
                .map(x -> x.stream().findFirst())
                .map(Optional::get)
                .orElse("ss");

        System.out.println(string);


    }
}
