package com.example.springscheduler.component;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ScheduledTasksTest {

  @SpyBean
  ScheduledTasks tasks;

  @Test
  public void reportCurrentTime(){
    await().atMost(Duration.ofSeconds(10)).untilAsserted(() -> {
      verify(tasks, atLeast(2)).reportCurrentTime();
    });
  }
}
