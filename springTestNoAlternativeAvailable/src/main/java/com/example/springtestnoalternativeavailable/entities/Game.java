package com.example.springtestnoalternativeavailable.entities;

public interface Game {

  void setHomeTeam(Team homeTeam);

  public Team getHomeTeam();

  void setAwayTeam(Team awayTeam);

  public Team getAwayTeam();

  public String playGame();
}
