package com.example.springtestnoalternativeavailable.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

public class BaseballGame implements Game{

  Team homeTeam;
  Team awayTeam;

  DataSource dataSource;

  public BaseballGame() {
  }

  public BaseballGame(Team homeTeam, Team awayTeam) {
    this.homeTeam = homeTeam;
    this.awayTeam = awayTeam;
  }

  @PostConstruct
  public void startGame(){
    System.out.println("Play national anthem.");
  }

  @PreDestroy
  public String endGame(){
    System.out.println("Send highlights to MLB.");
    return "blahh";
  }

  public DataSource getDataSource() {
    return dataSource;
  }

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void setHomeTeam(Team homeTeam){
    this.homeTeam = homeTeam;
  }
  @Override
  public Team getHomeTeam() {
    return homeTeam;
  }

  @Override
  public void setAwayTeam(Team awayTeam){
    this.awayTeam = awayTeam;
  }

  @Override
  public Team getAwayTeam() {
    return this.awayTeam;
  }

  @Override
  public String playGame() {
    return Math.random() > 0.5 ? this.homeTeam.getName() : this.awayTeam.getName();
  }

  @Override
  public  String toString(){
    return "The game of " + awayTeam.getName() + " at " + homeTeam.getName();
  }
}
