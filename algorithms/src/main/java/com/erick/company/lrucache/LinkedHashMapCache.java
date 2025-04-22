package com.erick.company.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapCache {
    //By default, a LinkedHashMap maintains entries in insertion-order.
    //But if you use the third constructor parameter accessOrder = true, it maintains entries in the order in which they were last accessed (via get() or put()).

    /*
    Explanation:
    LinkedHashMap supports access-order.

    When you call get() or put(), the accessed key is moved to the end (most recent).

    removeEldestEntry() is called after every put, and it tells Java when to evict the oldest entry.

    This gives you O(1) get() and put() with automatic eviction.
     */

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);

        map.put(1, "A"); // [1]
        map.put(2, "B"); // [1, 2]
        map.put(3, "C"); // [1, 2, 3]
        map.get(1);      // [2, 3, 1] ← 1 was accessed, so it goes to the end
        System.out.println(map);

        //This is super useful for LRU Cache, where the least recently used entry is at the front of the map.
        map.get(2); // // [3, 1, 2] ← 1 was accessed, so it goes to the end
        System.out.println(map);


        //Another example
        LinkedHashMap<Integer, String> lru = new LinkedHashMap<>(3, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > 3;
            }
        };

        lru.put(1, "A"); // [1]
        lru.put(2, "B"); // [1,2]
        lru.put(3, "C"); // [1,2,3]
        System.out.println(lru); // {1=A, 2=B, 3=C}

        lru.get(1); // [2,3,1]
        lru.put(4, "D"); // triggers removeEldestEntry (size > 3), removes 2
        System.out.println(lru); // {3=C, 1=A, 4=D}
    }

}
