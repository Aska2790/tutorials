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
        String sqlQuery = "SELECT * FROM Student WHERE Id = ?";
        return mTemplate.queryForObject(sqlQuery, new Object[] { studentId}, mRowMapper);
    }

    @Override
    public List<Student> selectAll() throws Exception {
        String sqlQuery = "SELECT * FROM Student";
        return mTemplate.query(sqlQuery, mRowMapper);
    }

    @Override
    public int insert(Student student) throws Exception {
        Objects.requireNonNull(student);
        String sqlQuery = "INSERT INTO Student (name, age) VALUES (?,?)";
        final int insertedRowCount = mTemplate.update(sqlQuery, student.getName(), student.getAge());
        if(insertedRowCount != 1){
            throw new IllegalStateException("Failed to save student record");
        }
        return insertedRowCount;
    }

    @Override
    public void update(Student student) throws Exception {
        Objects.requireNonNull(student);
        String sqlQuery = "UPDATE Student SET Name = ?, Age = ? WHERE Id = ?";
        final int updateRowCount = mTemplate.update(sqlQuery, student.getName(), student.getAge(), student.getId());
        if(updateRowCount != 1){
            throw new IllegalStateException("Failed to update student record");
        }
    }

    @Override
    public void delete(Student student) throws Exception {
        Objects.requireNonNull(student);
        delete(student.getId());
    }

    @Override
    public void delete(int studentId) throws Exception {
        String sqlQuery = "DELETE FROM Student WHERE Id = ?";
        final int deletedRowCount = mTemplate.update(sqlQuery, studentId);
        if(deletedRowCount != 1){
            throw new IllegalStateException("Failed to delete student record");
        }
    }

    //endregion
}
