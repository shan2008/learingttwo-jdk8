package com.yous.learningtwo.host;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by syou on 2017/12/26.
 */
public class Demo0 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(new Integer(1));
        set.add(new Integer(1));
        set.add(new Integer(1));

        System.out.println(set.size());
        System.out.println(set.iterator().next());


       /* Map<String, Integer> map = new HashMap<>(8);
        map.put("y", 1);
        map.put("s", 2);
        map.put("g", 3);

        for (Map.Entry<String, Integer> e: map.entrySet()){
            System.out.println(e.getKey() + e.getValue());
        }

        Iterator<Map.Entry<String,Integer>> it=map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,Integer> next=it.next();
            System.out.println(next.getKey() + next.getValue());
        }

        Map<String,Integer> maps=new ConcurrentHashMap<>();
        Map<String,Integer> hashMap=Collections.synchronizedMap(new HashMap<>());
        Map<String,Integer> treeMap=new TreeMap<>();
*/

    }
}
