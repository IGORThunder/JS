package annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component("dog")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Dog bean is created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Class Dog: init method");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Class Dog: destroy method");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow!");
    }
}
