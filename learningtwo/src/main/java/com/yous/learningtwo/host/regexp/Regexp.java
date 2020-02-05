package com.yous.learningtwo.host.regexp;

import org.apache.commons.collections4.map.CaseInsensitiveMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @author syou
 * @date 2019/8/8.
 */
public class Regexp {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();

        list.addAll(null);



        Pattern pattern = compile("yo");

        Matcher matcher = pattern.matcher("you are my  syon");

        while (matcher.find()){
            System.out.println(matcher.start());
            System.out.println(matcher.group());
        }

        Map<String,Integer> map=new HashMap<>();
        map.put("AAa",1);
        map.put("bAc",2);

        map=new CaseInsensitiveMap<>(map);

        System.out.println(map);



    }
}
