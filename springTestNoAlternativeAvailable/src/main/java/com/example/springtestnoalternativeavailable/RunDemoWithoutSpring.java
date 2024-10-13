package com.example.springtestnoalternativeavailable;

import com.example.springtestnoalternativeavailable.entities.BaseballGame;
import com.example.springtestnoalternativeavailable.entities.Cubs;
import com.example.springtestnoalternativeavailable.entities.Game;
import com.example.springtestnoalternativeavailable.entities.RedSox;
import com.example.springtestnoalternativeavailable.entities.Team;

public class RunDemoWithoutSpring {

  public static void main(String[] args){
    Team redSox = new RedSox();
    Team cubs = new Cubs();
    Game game = new BaseballGame(redSox,cubs);
    System.out.println(game.playGame());
  }
}
