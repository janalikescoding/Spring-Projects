package com.example.springbootdemoprojectnoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
@EntityScan({"com.example.*"})
@EnableJpaRepositories(basePackages = {"com.example.*"})
@EnableTransactionManagement
public class SpringBootDemoProjectNoWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoProjectNoWebApplication.class, args); //Instead of setting up ApplicationConfig, the SpringApplication has a static method: "run"
    // that just runs the actual application with any commandLine arguments that we provide. This is true even if it is a Web Application (which would use the embedded web server).

    //@EnableAutoConfiguration sees what jars we have added in and then adds corresponding capabilities to the application. It will detect all repositories for example.

    //Spring Boot with the JPA capabilities will take the entity and generate the DB schema(DB structure) based on it if we are using the datasource which is one of the embedded DB's (H2).
    //Embedded DB's do not show the datasource btw.
  }

}
