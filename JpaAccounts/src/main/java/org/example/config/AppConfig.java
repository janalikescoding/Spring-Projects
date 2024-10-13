package org.example.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.example")
//@PropertySource("classpath:prod.properties")
@EnableJpaRepositories(basePackages = "org.example.repositories")
@EnableTransactionManagement
public class AppConfig {

  @Autowired
  private Environment env;

  @Bean(name = "dataSource")
  //@Profile("test")
  public DataSource dataSourceForTest(){
    return new EmbeddedDatabaseBuilder()
        .generateUniqueName(true)
        .setType(EmbeddedDatabaseType.H2)
        .setScriptEncoding("UTF-8")
        .ignoreFailedDrops(true)
        .addScript("schema.sql")
        .addScripts("data.sql")
        .build();
  }

  @Bean(name = "transactionManager")
  //@Profile("test")
  public PlatformTransactionManager transactionManager(){
    return new DataSourceTransactionManager(dataSourceForTest());
  }

//  @Bean(name = "dataSource")
//  //@Profile("prod")
//  public DataSource dataSourceForProd(){
//    BasicDataSource dataSource = new BasicDataSource();
//    dataSource.setDriverClassName(env.getProperty("db.driver"));
//    dataSource.setUrl(env.getProperty("db.url"));
//    dataSource.setUsername(env.getProperty("db.user"));
//    dataSource.setPassword(env.getProperty("db.pass"));
//    return dataSource;
//  }
//
//  @Bean(name = "transactionManager")
//  //@Profile("prod")
//  public PlatformTransactionManager transactionManager(){
//    return new DataSourceTransactionManager(dataSourceForProd());
//  }

  @Bean
  public JpaVendorAdapter jpaVendorAdapter(){
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter(); //Indicate we want a JpaVendorAdapter for Hibernate
    adapter.setShowSql(true);
    adapter.setGenerateDdl(true);
    adapter.setDatabase(Database.MYSQL);
    return adapter;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory
      (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) { //We don't need to provide references to the dataSource() or jpaVendorAdapter() methods. Instead passing the type? as an argument will just let Spring wire them
    Properties properties = new Properties();
    properties.setProperty("hibernate.format_sql", String.valueOf(true)); //To format the code

    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
    emf.setDataSource(dataSource);
    emf.setPackagesToScan("org.example.entities");
    emf.setJpaVendorAdapter(jpaVendorAdapter);
    emf.setJpaProperties(properties);

    return emf;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf) { //Same as above. Just pass in the bean type as an argument and Spring wires it.
    return new JpaTransactionManager(emf); //Manage transaction using EMF
  }

  @Bean
  public BeanPostProcessor persistenceTranslation() { //Helps in translation of exceptions from API, JPA, Hibernate
    return new PersistenceExceptionTranslationPostProcessor();
  }
}
