package com.vicrum.books.gradleGroovy.java21.cash;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;

@Aspect
public class CachingAspect {

    private final CacheManager cacheManager = new CacheManager();

    @Around("@annotation(cacheable)")
    public Object cache(ProceedingJoinPoint joinPoint, Cacheable cacheable) throws Throwable {
        Method method = getMethod(joinPoint);
        Object[] args = joinPoint.getArgs();

        String cacheKey = cacheManager.generateCacheKey(args[0].toString());
        Object cachedResult = cacheManager.getFromCache(cacheKey);

        if (cachedResult != null) {
            System.out.println("Cache exists! Result for key: " + cacheKey);
            return cachedResult;
        } else {
            System.out.println("Cache miss! Proceeding with method execution for key: " + cacheKey);
            Object result = joinPoint.proceed();
            cacheManager.putInCache(cacheKey, result);
            return result;
        }
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        return ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature()).getMethod();
    }
}

