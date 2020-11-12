package com.aska.development.spring_jdbc.dao;

import com.aska.development.spring_jdbc.model.Student;

import java.util.List;

public interface StudentDao {

    Student select(int studentId) throws Exception;

    List<Student> selectAll() throws Exception;

    int insert(Student student) throws Exception;

    void update(Student student) throws Exception;

    void delete(Student student) throws Exception;

    void delete(int studentId) throws Exception;
}
