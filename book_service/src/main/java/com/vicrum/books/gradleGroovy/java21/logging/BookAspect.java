package com.vicrum.books.gradleGroovy.java21.logging;

import com.vicrum.books.gradleGroovy.java21.app.config.AppConfig;
import com.vicrum.books.gradleGroovy.java21.domain.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class BookAspect {
    @Autowired
    @Qualifier("appLogger")
    private Logger logger;

    @Autowired
    public BookAspect() {
    }

    @Pointcut("execution(public * com.vicrum.books.gradleGroovy.java21.service.BookServiceImplementation.*(..))")
    public void callAtMyService() {
    }

    @Before("callAtMyService()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        logger.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @AfterReturning(pointcut = "execution(public * com.vicrum.books.gradleGroovy.java21.service.BookServiceImplementation.*(..))", returning = "result")
    public void afterReturningWithList(JoinPoint joinPoint, List<Book> result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After returning from method ");
        for (Book book : result) {
            logger.info("Book ID: " + book.getId() + ", Name: " + book.getName() +
                    ", Author: " + book.getAuthor() + ", Description: " + book.getDescription());
        }
    }

    @AfterReturning(pointcut = "execution(public * com.vicrum.books.gradleGroovy.java21.service.BookServiceImplementation.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Book result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After returning from method ");
        if (result != null) {
            logger.info("Book ID: " + result.getId() + ", Name: " + result.getName() +
                    ", Author: " + result.getAuthor().toString() + ", Description: " + result.getDescription().toString() + ", GridFS : " + result.getGridFsImageId().toString());
        } else {
            logger.info("No book returned");
        }
    }

    @AfterReturning("execution(public * com.vicrum.books.gradleGroovy.java21.service.BookServiceImplementation.delete(..))")
    public void afterReturningVoidMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After returning from method ");
    }
}
