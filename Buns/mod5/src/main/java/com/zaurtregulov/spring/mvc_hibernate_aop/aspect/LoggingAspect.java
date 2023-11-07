package com.zaurtregulov.spring.mvc_hibernate_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.zaurtregulov.spring.mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint joinPoint) throws
            Throwable {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of method: " + methodName);
        Object result = joinPoint.proceed();
        System.out.println("End of method: " + methodName);
        return result;
    }
}
