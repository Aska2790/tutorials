package com.aska.development.spring_jdbc.db.dao;

import com.aska.development.spring_jdbc.dao.StudentDao;
import com.aska.development.spring_jdbc.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

public class StudentDaoImpl implements StudentDao {

    //region Fields

    private NamedParameterJdbcTemplate mTemplate;
    private RowMapper<Student> mRowMapper;

    //endregion

    //region Constructors

    public StudentDaoImpl(NamedParameterJdbcTemplate template, RowMapper<Student> rowMapper) {

        Objects.requireNonNull(template);
        Objects.requireNonNull(rowMapper);

        mRowMapper = rowMapper;
        mTemplate = template;
    }

    //endregion

    //region Methods

    @Override
    public Student select(int studentId) throws Exception {
        String sqlQuery = "SELECT * FROM Student WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", studentId);
        return mTemplate.queryForObject(sqlQuery, parameterSource, mRowMapper);
    }

    @Override
    public List<Student> selectAll() throws Exception {
        String sqlQuery = "SELECT * FROM Student";
        return mTemplate.query(sqlQuery, mRowMapper);
    }

    @Override
    public int insert(Student student) throws Exception {
        Objects.requireNonNull(student);
        String sqlQuery = "INSERT INTO Student (name, age, image) VALUES (:name, :age, :image)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", student.getName());
        parameterSource.addValue("age", student.getAge());
        parameterSource.addValue("image", student.getImage());

        final int insertedRowCount = mTemplate.update(sqlQuery, parameterSource);
        if(insertedRowCount != 1){
            throw new IllegalStateException("Failed to save student record");
        }
        return insertedRowCount;
    }

    @Override
    public void update(Student student) throws Exception {
        Objects.requireNonNull(student);
        String sqlQuery = "UPDATE Student SET name = :name, age = :age, image = :image WHERE id = :id";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", student.getId());
        parameterSource.addValue("name", student.getName());
        parameterSource.addValue("age", student.getAge());
        parameterSource.addValue("image", student.getImage());

        final int updateRowCount = mTemplate.update(sqlQuery, parameterSource);
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
        String sqlQuery = "DELETE FROM Student WHERE id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", studentId);
        final int deletedRowCount = mTemplate.update(sqlQuery, parameterSource);
        if(deletedRowCount != 1){
            throw new IllegalStateException("Failed to delete student record");
        }
    }

    //endregion
}
