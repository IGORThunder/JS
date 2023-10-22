package aop.aspects;

import aop.Book;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class GetMethodsAspect {

    @Around("aop.aspects.Pointcuts.pointcutGetBookAdvice()")
    public Object aroundGetBookAdvice(ProceedingJoinPoint joinPoint)
            throws Throwable {
        System.out.println("Trying to get a book");
        Object targetMethodResult = null;
        try {
            targetMethodResult = joinPoint.proceed();
            System.out.println("Book received");
        } catch (Throwable throwable) {
            targetMethodResult = new Book("Unknown book", "Unknown author");
            System.out.println("This book is not in the library");
        }
        System.out.println("---------------------------------------------------------------");
        return targetMethodResult;
    }
}
