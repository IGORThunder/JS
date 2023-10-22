package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class AddMethodsAspect {

    @Before("aop.aspects.Pointcuts.pointcutAddBookAdvice()")
    public void beforeAddBookAdvice() {
        System.out.println("Adding a book to the library");
        System.out.println("---------------------------------------------------------------");
    }
}
