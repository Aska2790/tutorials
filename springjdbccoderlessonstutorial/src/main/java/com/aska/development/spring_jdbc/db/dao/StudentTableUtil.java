package com.aska.development.spring_jdbc.db.dao;

import com.aska.development.spring_jdbc.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.SqlQuery;

import java.util.Map;
import java.util.Objects;

public class StudentTableUtil {

    //region Fields

    private SimpleJdbcCall mJdbcCall;
    private NamedParameterJdbcTemplate mTemplate;

    //endregion

    //region Constructors

    public StudentTableUtil(NamedParameterJdbcTemplate template, SimpleJdbcCall jdbcCall) {
        Objects.requireNonNull(template);
        Objects.requireNonNull(jdbcCall);
        mTemplate = template;
        mJdbcCall = jdbcCall;

    }

    //endregion

    //region Methods

    public void drop() {
        String sqlQuery = "DROP TABLE IF EXISTS Student";
        mTemplate.getJdbcTemplate().execute(sqlQuery);
    }

    public void create() {
        drop();
        String sqlQuery = "CREATE TABLE Student(" +
                "Id INT NOT NULL AUTO_INCREMENT," +
                " Name VARCHAR(100) NOT NULL," +
                " Age INT NOT NULL," +
                "Image BLOB," +
                "PRIMARY KEY (Id)" +
                ");";

        mTemplate.getJdbcTemplate().execute(sqlQuery);
    }


    public Student getRecordProcedure(int studentId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("studentId", studentId);

        Map<String, Object> output =  mJdbcCall
                .withProcedureName("get_record")
                .execute(parameterSource);

        String studentName = (String) output.get("student_name");
        int studentAge = (int) output.get("student_age");

        Student student = new Student(studentId);
        student.setName(studentName);
        student.setAge(studentAge);

        return student;
    }

    public String getStudentName(int studentId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("studentId", studentId);

        return mJdbcCall
                .withFunctionName("get_student_name")
                .executeFunction(String.class, parameterSource);
    }
    //endregion
}
