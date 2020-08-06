package com.aska.development.mockito.model;

import java.util.Objects;

public class User {

    //region Fields

    private int mId;
    private String mName;
    private String mRole;

    //endregion

    //region Properties

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    //endregion

    //region Constructors

    public User(String name, String role) {
        mName = name;
        mRole = role;
    }

    public User(String name) {
        mName = name;
    }

    //endregion

    //region Methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return mId == user.mId &&
                mName.equals(user.mName) &&
                mRole.equals(user.mRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mRole);
    }


    //endregion

}
