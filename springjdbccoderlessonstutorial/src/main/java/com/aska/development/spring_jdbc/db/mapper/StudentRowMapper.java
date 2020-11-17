package com.aska.development.spring_jdbc.db.mapper;

import com.aska.development.spring_jdbc.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    //region Methods

    @Override
    public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        int studentId = resultSet.getInt("Id");
        String studentName = resultSet.getString("Name");
        int studentAge = resultSet.getInt("Age");
        byte[] studentImage =  resultSet.getBytes("Image");

        final Student student = new Student(studentId);
        student.setName(studentName);
        student.setAge(studentAge);
        student.setImage(studentImage);
        return student;
    }

    //endregion
}
