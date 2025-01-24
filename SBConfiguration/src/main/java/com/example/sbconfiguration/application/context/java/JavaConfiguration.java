package com.example.sbconfiguration.application.context.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {

    @Bean
    public String javaBean1(){
        return "javaBean1";
    }

    @Bean
    public String javaBean2(){
        return "javaBean2";
    }
}
