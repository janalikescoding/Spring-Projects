package com.example.spring28mybatis.repository;

import com.example.spring28mybatis.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMyBatisRepository {

  @Select("select * from student where id = #{id}")
  public Student findById(long id);

  @Select("select * from student")
  public List<Student> findAll();

  @Delete("delete from student where id = #{id}")
  public int deleteStudent(long id);

  @Insert("insert into student(id, name, passport) values(#{id}, #{name}, #{passport})")
  public int insertStudent(Student student);

  @Update("update student set name=#{name}, passport=#{passport} where id = #{id}")
  public int updateStudent(Student student);
}
