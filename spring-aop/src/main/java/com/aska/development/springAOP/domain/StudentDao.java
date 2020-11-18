package com.aska.development.springAOP.domain;

public interface StudentDao {
    Student select(int id);

    void insert(Student student);
}
