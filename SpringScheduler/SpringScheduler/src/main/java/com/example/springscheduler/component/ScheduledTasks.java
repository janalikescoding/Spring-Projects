package com.example.springscheduler.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
  private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 5000) //Call the function at a given interval. Also can use cron(), fixedDelay() instead of fixedRate(). initialDelay() gives a one-time delay before the first call.
  public void reportCurrentTime(){
    log.info("The time is now {}", dateFormat.format(new Date()));
  }
}
