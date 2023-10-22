package javaConfig2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    @Scope("prototype")
    public Pet cat() {
        return new Cat();
    }

    @Bean
    public Person person() {
        return new Person(cat());
    }
}
