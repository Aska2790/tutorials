package com.aska.development.springAOP.data;

import com.aska.development.springAOP.domain.Student;
import com.aska.development.springAOP.domain.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student select(int id) {
        return new Student(id, "Student : " + id);
    }

    @Override
    public void insert(Student student) {

    }
}
