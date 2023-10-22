package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(public aop.Book getBook(String))")
    public void pointcutGetBookAdvice() {

    }

    @Pointcut("execution(public void addBook(aop.Book))")
    public void pointcutAddBookAdvice() {

    }

    @Pointcut("execution(* *(..)) && !execution(String toString())")
    public void pointcutAllMethodsAdvice() {

    }
}
