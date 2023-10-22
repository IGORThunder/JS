package aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(5)
public class AllMethodsAspect {

    @Before("aop.aspects.Pointcuts.pointcutAllMethodsAdvice()")
    public void beforeAllMethodsAdvice(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature.getName()
                + "\nReturn type: " + signature.getReturnType()
                + "\nArguments: " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("---------------------------------------------------------------");
    }
}
