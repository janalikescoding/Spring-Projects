package com.example.restsoap.controller;

import com.example.restsoap.RestSoapApplication;
import com.example.restsoap.model.Course;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RestSoapApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT { //This tests the entire application by creating a test restTemplate for the REST operation.

  @LocalServerPort
  private int port;
  TestRestTemplate restTemplate = new TestRestTemplate();
  HttpHeaders headers = new HttpHeaders();

  @Test
  public void testRetrieveStudentCourse() throws JSONException {
    HttpEntity<String> entity = new HttpEntity<>(null, headers);
    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/students/Student1/courses/Course1"),
        HttpMethod.GET, entity, String.class);
    String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":\"10Steps\"}";
    JSONAssert.assertEquals(expected, response.getBody(), false);
  }

  private String createURLWithPort(String uri){
    return "http://localhost:"+ port + uri;
  }

  @Test
  public void testAddCourse(){
    Course course = new Course("Course1", "Spring", "10 Steps",
        List.of("Learn Maven", "Import Project", "First Example", "Second Example"));
    HttpEntity<Course> entity = new HttpEntity<>(course, headers);
    ResponseEntity<String> response = restTemplate.exchange(
        createURLWithPort("/students/Student1/courses"),
        HttpMethod.POST, entity, String.class);
    String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
    assertTrue(actual.contains("/students/Student1/courses/"));
  }
}
