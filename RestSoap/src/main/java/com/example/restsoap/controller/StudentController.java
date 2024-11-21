package com.example.restsoap.controller;

import com.example.restsoap.model.Course;
import com.example.restsoap.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/courses")
public class StudentController {

  @Autowired
  StudentService studentService;

  @GetMapping()
  public List<Course> getCoursesForStudent(@PathVariable String studentId){
    return studentService.retrieveCourses(studentId);
  }

  @GetMapping("/{courseId}")
  public Course getDetailsForCourse(@PathVariable String studentId, @PathVariable String courseId){
    return studentService.retrieveCourse(studentId, courseId);
  }

  @PostMapping()
  public ResponseEntity<Object> addCourse(@PathVariable String studentId, @RequestBody Course course){
    Course createdCourse = studentService.addCourse(studentId, course);
    if(createdCourse == null){
      return ResponseEntity.noContent().build();
    }
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(createdCourse.id()).toUri();

    return ResponseEntity.created(location).build();
  }
}
