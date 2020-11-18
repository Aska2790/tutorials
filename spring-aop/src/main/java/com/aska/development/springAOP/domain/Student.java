package com.aska.development.springAOP.domain;

public class Student {

    //region Fields

    private int mId;
    private String mName;

    //endregion

    //region Properties

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    //endregion

    //region Constructors

    public Student(int id, String name) {
        mId = id;
        mName = name;
    }

    //endregion

    //region Methods

    @Override
    public String toString() {
        return "Student{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                '}';
    }

    //endregion
}
