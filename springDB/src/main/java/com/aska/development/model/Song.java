package com.aska.development.model;

public class Song {

    //region Fields

    private String mName;
    private String mAuthor;

    //endregion

    //region Properties

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    //endregion

    //region Constructors

    public Song(String name, String author) {
        mName = name;
        mAuthor = author;
    }

    public Song() {
    }

    //endregion


    @Override
    public String toString() {
        return String.format("Author : %s\nName : %s", mAuthor, mName);
    }
}
