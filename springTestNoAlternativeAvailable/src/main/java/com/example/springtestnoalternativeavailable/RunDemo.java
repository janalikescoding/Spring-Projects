package com.example.springtestnoalternativeavailable;

import com.example.springtestnoalternativeavailable.entities.Cubs;
import com.example.springtestnoalternativeavailable.entities.Game;
import com.example.springtestnoalternativeavailable.entities.RedSox;
import com.example.springtestnoalternativeavailable.entities.Royals;
import com.example.springtestnoalternativeavailable.entities.Team;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.parsers.DocumentBuilder;
import java.text.NumberFormat;

public class RunDemo {

  public static void main(String[] args){
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//    Game game = context.getBean("game", Game.class);
//
////    Team royals =  context.getBean("royals", Team.class);
////    game.setAwayTeam(royals); // Setter injection
//
//    System.out.println(game.playGame());
//    System.out.println("There are " + context.getBeanDefinitionCount() + " beans.");
//
//    for (String name: context.getBeanDefinitionNames()) {
//      System.out.println(name);
//    }
//
//    NumberFormat nf = context.getBean("nf",NumberFormat.class);
//    double amount = 123456.7890;
//    System.out.println(nf.format(amount));
//    context.close();

//    DocumentBuilder documentBuilder = context.getBean("documentBuilder",DocumentBuilder.class);
//    System.out.println(documentBuilder.toString());

//    Team royals = context.getBean("royals", Team.class);
//
//    Game game1 = context.getBean("game", Game.class);
//    System.out.println(game1);
//
//    Game game2 = context.getBean("game", Game.class);
//    game2.setAwayTeam(royals);
//    System.out.println(game2);
//
//    System.out.println(game1);

    //AOP Test - 1
    // Observation 1: Aspect callSetters called on all setters in the com.example package.
    // Observation 2: Although setAwayTeam is called second, while logging, Spring knows what the away team would be already. (Maybe all setters are called together?).
    Game game = context.getBean("game", Game.class);
    Team cubs = context.getBean("cubs", Cubs.class);
    Team redSox = context.getBean("redSox", RedSox.class);
    Team royals = context.getBean("royals", Royals.class);

    game.setHomeTeam(royals);
    game.setAwayTeam(cubs);
    game.playGame();

    game.setHomeTeam(cubs);
    game.setAwayTeam(redSox);
    game.playGame();

    context.close();
  }
}
