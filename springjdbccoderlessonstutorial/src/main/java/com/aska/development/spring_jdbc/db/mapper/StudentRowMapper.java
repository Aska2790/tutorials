package com.aska.development.spring_jdbc.db.mapper;

import com.aska.development.spring_jdbc.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    //region Methods

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }

    //endregion
}
