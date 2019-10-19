package com.hascode.tutorial;

import java.util.HashMap;
import java.util.Map;

public class MagicCounter implements Counter {
    private final Map<Long, Long> map;

    public MagicCounter(int numberOfThreads) {
        map = new HashMap<>(numberOfThreads);
    }

    @Override
    public void increment() {
        long id = Thread.currentThread().getId();
        map.put(id, map.containsKey(id) ? map.get(id) + 1 : 1);
    }

    @Override
    public long getValue() {
        return map.values().stream().mapToLong(value -> value).sum();
    }
}
