package com.aska.development.spring_jdbc.db.dao;

import org.springframework.jdbc.core.JdbcTemplate;

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

    //endregion
}
