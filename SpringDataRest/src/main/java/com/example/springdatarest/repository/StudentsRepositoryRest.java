package com.example.springdatarest.repository;

import com.example.springdatarest.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students", collectionResourceRel = "students")
public interface StudentsRepositoryRest extends PagingAndSortingRepository<Student,Long> {
}
