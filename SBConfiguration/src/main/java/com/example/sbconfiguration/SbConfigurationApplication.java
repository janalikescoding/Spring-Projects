package com.example.sbconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SbConfigurationApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SbConfigurationApplication.class, args);

        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
    }

}
