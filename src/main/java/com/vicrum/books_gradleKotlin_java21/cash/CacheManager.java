package com.vicrum.books_gradleKotlin_java21.cash;

import java.lang.reflect.Method;
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

    public String generateCacheKey(Method method, Object[] args) {
        StringBuilder keyBuilder = new StringBuilder(method.getName());
        for (Object arg : args) {
            keyBuilder.append("_").append(arg.toString());
        }
        return keyBuilder.toString();
    }

}
