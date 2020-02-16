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
}