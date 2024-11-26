package com.example.restsoap.controller;

import com.example.restsoap.model.Course;
import com.example.restsoap.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = StudentController.class)
@WithMockUser
public class StudentControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  private StudentService studentService;

  Course mockCourse = new Course("Course1", "Spring", "10Steps",
      Arrays.asList("Learn Maven", "Import Project", "First Example", "Second Example"));

  String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

  @Test
  public void retrieveDetailsForCourseTest() throws Exception{
    Mockito.when(studentService.retrieveCourse(Mockito.anyString(),Mockito.anyString())).thenReturn(mockCourse);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/students/Student1/courses/Course1").accept(MediaType.APPLICATION_JSON);

    MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

    System.out.println(mvcResult.getResponse());
    String expected = "{\"id\":\"Course1\",\"name\":\"Spring\",\"description\":\"10Steps\"}";

    JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(),false);
  }

  @Test
  public void createStudentCourseTest() throws Exception{
    Course mockCourse = new Course("1", "Smallest Number", "1",
        Arrays.asList("1", "2", "3", "4"));

    Mockito.when(studentService.addCourse(Mockito.anyString(), Mockito.any(Course.class))).thenReturn(mockCourse);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/students/Student1/courses")
        .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
        .contentType(MediaType.APPLICATION_JSON);

    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    MockHttpServletResponse response= result.getResponse();

    assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    assertEquals("http://localhost/students/Student1/courses/1",
        response.getHeader(HttpHeaders.LOCATION));
  }

}
