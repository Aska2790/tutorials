package com.aska.development.spring_jdbc.model;

public class Student {
    //region Fields

    private int mId;
    private String name;
    private int mAge;

    //endregion

    //region Properties

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    //endregion

    //region Constructors

    public Student(int id, String name, int age) {
        mId = id;
        this.name = name;
        mAge = age;
    }

    public Student() {

    }

    //endregion
}
