package com.aska.development.spring_jdbc.db.dao;

import com.aska.development.spring_jdbc.dao.StudentDao;
import com.aska.development.spring_jdbc.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

public class StudentDaoImpl implements StudentDao {

    //region Fields

    private JdbcTemplate mTemplate;
    private RowMapper<Student> mRowMapper;

    //endregion

    //region Constructors

    public StudentDaoImpl(JdbcTemplate template, RowMapper<Student> rowMapper) {

        Objects.requireNonNull(template);
        Objects.requireNonNull(rowMapper);

        mRowMapper = rowMapper;
        mTemplate = template;
    }

    //endregion

    //region Methods

    @Override
    public Student select(int studentId) throws Exception {
        throw new RuntimeException();
    }

    @Override
    public List<Student> selectAll() throws Exception {
        throw new RuntimeException();
    }

    @Override
    public int insert(Student student) throws Exception {
        throw new RuntimeException();
    }

    @Override
    public void update(Student student) throws Exception {
        throw new RuntimeException();
    }

    @Override
    public void delete(Student student) throws Exception {
        throw new RuntimeException();
    }

    @Override
    public void delete(int studentId) throws Exception {
        throw new RuntimeException();
    }

    //endregion
}
