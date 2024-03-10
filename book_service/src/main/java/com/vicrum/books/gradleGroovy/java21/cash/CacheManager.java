package com.vicrum.books.gradleGroovy.java21.cash;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    private final Map<String, Object> cache = new HashMap<>();

    public Object getFromCache(String key) {
        return cache.get(key);
    }

    public void putInCache(String key, Object value) {
        cache.put(key, value);
    }

    public String generateCacheKey(String param) {
        System.out.println(param);
        return param;
    }

}
