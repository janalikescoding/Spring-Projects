package com.example.springtestnoalternativeavailable;

import com.example.springtestnoalternativeavailable.entities.BaseballGame;
import com.example.springtestnoalternativeavailable.entities.Cubs;
import com.example.springtestnoalternativeavailable.entities.Game;
import com.example.springtestnoalternativeavailable.entities.RedSox;
import com.example.springtestnoalternativeavailable.entities.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.text.NumberFormat;
import java.util.List;

@Configuration
//@Import(InfrastructureConfig.class) // Import another configuration class
@ComponentScan(basePackages = "com.example"
//    , excludeFilters = {
//    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = InfrastructureConfig.class),
//    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = SpringTestNoAlternativeAvailableApplication.class)}
)
@EnableAspectJAutoProxy //This enables AOP. AspectJ generates a proxy in front of the bean, then when an aspect is applied, it goes in and out of a proxy to perform operation
public class AppConfig {

  @Autowired //Autowire by type
  private DataSource dataSource;

  @Resource //autowire by name: redSox
  private Team redSox;

  @Bean
  public NumberFormat nf(){
    return NumberFormat.getCurrencyInstance(); // The whole idea of factory is to help provide instances where it might not be that obvious(abstract class/interface)
  }

  @Autowired
  private List<Team> teams; // OR the other approach is to autowire the beans into a collection like List<Team> and iterate through them while using them (in the game).

  @Autowired @Qualifier("cubs") //autowire by type: Teams; @Qualifier to specify the bean name (default - class name with lowercase starting letter)
  private Team away;

  @Bean//(initMethod = "startGame", destroyMethod = "endGame") //Use initMethod, destroyMethod if you don't own the source code to the bean. Otherwise, use annotation @PostConstruct, @PreDestroy directly on the methods themselves. Note: Lifecycle methods should not have arguments (and returns void??? - I am not sure.) (AppConfig or direct annotation).
  @Scope("prototype") //Prototype: Everytime the bean is instantiated, give a new instance. By default, all Spring managed beans are singletons. Singleton is made default by Spring because it expects to manage singletons(with no much customization) like services, repository. It is not looking to replace every new keyword in the code(Prototype?).
  //public Game game(DataSource dataSource, Team cubs, Team redSox){
  //public Game game(DataSource dataSource){
  public Game game(){
//    BaseballGame retVal = new BaseballGame(redSox(), cubs());
//    BaseballGame retVal = new BaseballGame(redSox, away);
    BaseballGame retVal = new BaseballGame(teams.get(0), teams.get(1)); // Constructor injection; no point in having a game if 2 teams don't show up.
//    BaseballGame retVal = new BaseballGame();
//    retVal.setHomeTeam(away);
//    retVal.setAwayTeam(redSox);
    retVal.setDataSource(dataSource);
    return retVal;
  }

//  @Bean // Java-based configuration, declaring beans using @Bean annotation. FROM DOC: Indicates that a method produces a bean to be managed by the Spring container.
//  public Team cubs(){
//    return new Cubs();
//  }
//
//  @Bean
//  public Team redSox(){ // In bean based configuration, redSox() may be considered to be a subclass which returns singletons - If instance already exists, return the instance otherwise instantiate, do super() where you set it to the parent, then return the instance.
//    return new RedSox();
//  }

  //@Scope("singleton") - default
  //@Scope("prototype") - new instance everytime the bean is retreived using context.
  // If we are in spring MVC, "request", "session".
  // Plus, custom scopes as well.
}


// Setter and Constructor injection can be used based on requirement. But if we have a dependency is absolutely required, which makes the Parent bean useless otherwise, use constructor because it throws an error if we forget to set it.
