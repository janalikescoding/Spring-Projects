package com.example.spring28jdbc.repository;

import com.example.spring28jdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository{
  @Autowired
  JdbcTemplate jdbcTemplate;

  public Student findById(long id){
    return jdbcTemplate.queryForObject("select * from student where id=?", new BeanPropertyRowMapper<>(Student.class), id);
  }

  private class StudentRowMapper implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
      Student s = new Student();
      s.setId(rs.getLong("id"));
      s.setName(rs.getString("name"));
      s.setPassportNumber(rs.getString("passport_number"));
      return s;
    }
  }

  public List<Student> findAll(){
    return jdbcTemplate.query("select * from student", new StudentRowMapper());
  }

  public int insert(long id, String name, String passportNumber){
    jdbcTemplate.update("insert into student values(?,?,?)", id, name, passportNumber);
    return (int)id;
  }

  public Student update(long id, String name, String passportNumber){
    jdbcTemplate.update("update student set name=?, passport_number=? where id=?",name, passportNumber, id);
    return findById(id);
  }

  public List<Student> delete(long id){
    jdbcTemplate.update("delete from student where id=?",id);
    return findAll();
  }
}

