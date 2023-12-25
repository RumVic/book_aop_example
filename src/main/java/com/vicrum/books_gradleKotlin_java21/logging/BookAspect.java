package com.vicrum.books_gradleKotlin_java21.logging;

import com.vicrum.books_gradleKotlin_java21.entity.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class BookAspect {

    private final AppAOPConfig appAOPConfig;

    public BookAspect(AppAOPConfig appAOPConfig) {
        this.appAOPConfig = appAOPConfig;
    }

    @Pointcut("execution(public * com.vicrum.books_gradleKotlin_java21.service.BookService.*(..))")
    public void callAtMyService() {
    }

    @Before("callAtMyService()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        appAOPConfig.logger().info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @AfterReturning(pointcut = "execution(public * com.vicrum.books_gradleKotlin_java21.service.BookService.*(..))", returning = "result")
    public void afterReturningWithList(JoinPoint joinPoint, List<Book> result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After returning from method ");
        for (Book book : result) {
            System.out.println("Book ID: " + book.getId() + ", Name: " + book.getName() +
                    ", Author: " + book.getAuthor() + ", Description: " + book.getDescription());
        }
    }

    @AfterReturning(pointcut = "execution(public * com.vicrum.books_gradleKotlin_java21.service.BookService.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Book result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After returning from method ");
        if (result != null) {
            System.out.println("Book ID: " + result.getId() + ", Name: " + result.getName() +
                    ", Author: " + result.getAuthor() + ", Description: " + result.getDescription());
        } else {
            System.out.println("No book returned");
        }
    }

    @AfterReturning("execution(public * com.vicrum.books_gradleKotlin_java21.service.BookService.delete(..))")
    public void afterReturningVoidMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After returning from method ");
    }
}
