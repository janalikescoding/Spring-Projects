package com.example.springtestnoalternativeavailable;

import com.example.springtestnoalternativeavailable.entities.Game;
import com.example.springtestnoalternativeavailable.entities.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class) //Specify the runner
@ContextConfiguration(classes = AppConfig.class) //Specify the Bean Config file using 'classes' attribute. Could be different for different environments for instance.
// Spring Testing is best for integration testing because we can cache the ApplicationContext to autowire the test fixture and even provide(or obtain) the ApplicationContext in case we want it.
// For unit tests, prefer a mocking framework because unit test would not use Spring infrastructure(or Spring in any way)
@Transactional // We can apply this annotation at a method level or the class level. When the testing is complete, any operation (DB save for example) will be rolled back by Spring and nothing will have actually changed.
// Transaction can be handled in other ways too - @Commit - commit (at class level commit all methods), @BeforeTransaction, @AfterTransaction, @Rollback - executed for rollback automatically.
// @DirtiesContext - Indicate that this test modifies(dirties) the application context. So, when this annotation is applied, the context is reloaded.
public class BaseballGameTest {

  // Spring repository = Java DAO layer
  @Autowired //Just autowiring helps map the game (assuming there is only one instance of game in AppConfig)
  private Game game;

  @Autowired //Application Context can also be autowired
  private AnnotationConfigApplicationContext context;

  //@BeforeEach provided by JUnit.
  // The problem here is that before each test the application context is fired-up and shut down which is not efficient when a large number of test cases are involved.
//  @BeforeEach
//  public void setUp(){
//    context = new AnnotationConfigApplicationContext(AppConfig.class);
//    game = context.getBean("game", Game.class);
//  }

  @Test
  public void testPlayGame() throws Exception{
    String home = game.getHomeTeam().getName();
    String away = game.getAwayTeam().getName();

    String result = game.playGame();

    assertTrue(result.contains(home) || result.contains(away));

  }

  @Test
  public void testGetandSetHomeTeam() throws Exception {
    Team royals = context.getBean("royals", Team.class);
    game.setHomeTeam(royals);
    assertEquals(royals.getName(), game.getHomeTeam().getName());
  }
}
