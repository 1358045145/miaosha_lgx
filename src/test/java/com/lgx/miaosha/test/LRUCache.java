package com.lgx.miaosha.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 模拟LRU算法实现(移除最近最少使用的key)
 */
public class LRUCache extends LinkedHashMap {
    private static final Integer MAX_CAPCITY = 3;
    public LRUCache(){
        super(MAX_CAPCITY,0.75f,true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_CAPCITY;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put(1,5);
        lruCache.put(2,8);
        lruCache.put(3,99);

        for (Object o : lruCache.keySet()) {
            System.out.print(o + " ");     //预期结果1 - 2 - 3
        }
        lruCache.get(1);                   //使用1  将1移到链表的尾部
        lruCache.put(4,1919);              //添加进来一个元素超过三个，触发LRU，2是链表首部的，移除

        System.out.println();
        for (Object o : lruCache.keySet()) {
            System.out.print(o + " ");     //预期结果 3 - 1 - 4
        }

    }


}
