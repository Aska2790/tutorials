package com.aska.development.spring_jdbc.db.dao;

import com.aska.development.spring_jdbc.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.Map;
import java.util.Objects;

public class StudentTableUtil {

    //region Fields

    private JdbcTemplate mTemplate;

    //endregion

    //region Constructors

    public StudentTableUtil(JdbcTemplate template) {
        Objects.requireNonNull(template);
        mTemplate = template;
    }

    //endregion

    //region Methods

    public void drop(){
        String sqlQuery = "DROP TABLE IF EXISTS Student";
        mTemplate.execute(sqlQuery);
    }

    public void create(){
        drop();
        String sqlQuery = "CREATE TABLE Student(" +
                "Id INT NOT NULL AUTO_INCREMENT," +
                " Name VARCHAR(100) NOT NULL," +
                " Age INT NOT NULL," +
                "PRIMARY KEY (Id)" +
                ");";

        mTemplate.execute(sqlQuery);
    }


    public Student getRecordProcedure(int studentId){
        SimpleJdbcCall call = new SimpleJdbcCall(mTemplate.getDataSource());
        call.withProcedureName("get_record");

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("studentId", studentId);

        final Map<String, Object> out = call.execute(sqlParameterSource);
        return new Student(studentId, (String) out.get("student_name"), (int) out.get("student_age"));
    }

    public String getStudentName(int studentId){
        SimpleJdbcCall call = new SimpleJdbcCall(mTemplate.getDataSource());
        call.withFunctionName("get_student_name");

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("studentId", studentId);

         return call.executeFunction(String.class, sqlParameterSource);
    }
    //endregion
}
