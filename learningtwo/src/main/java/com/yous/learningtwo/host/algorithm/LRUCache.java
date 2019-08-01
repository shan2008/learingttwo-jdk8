package com.yous.learningtwo.host.algorithm;

import java.util.*;

/**
 * @author syou
 * @date 2019/7/1.
 */
public class LRUCache<K, v> extends LinkedHashMap {


    private final int cacheSize;

    public LRUCache(int cacheSize) {
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new LRUCache<>(4);
        map.put(1, "a");
        map.put(2, "b");
        map.put(4, "c");
        map.put(6, "d");
        map.put(7, "d");
        map.forEach((K,v)->{
            System.out.println(K+":"+v);
        });

    }


    public static void test(long id){

    }
}
