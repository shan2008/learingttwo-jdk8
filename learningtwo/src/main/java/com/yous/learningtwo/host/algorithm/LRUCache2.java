package com.yous.learningtwo.host.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author syou
 * @date 2019/12/3.
 */
public class LRUCache2 {
    Map<Integer, Integer> cache;

    public LRUCache2(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };

    }

}
