package com.erick.company.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        // true = access order (not insertion order)
        super(capacity, 0.75f, true);
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) { //Inner class
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity; //If the map exceeds the given capacity, the eldest (least recently used) entry is removed.
            }// LRUCache.this.capacity refers to the outer class's capacity field (the one in LRUCache).
            // This is needed because you're inside an inner class and want access to the outer class’s property.
        };
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    // When to remove the eldest entry? When size exceeds capacity
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
