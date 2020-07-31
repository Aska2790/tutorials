package com.radiy.lcs.dagger.model;

/**
 * we don`t own this class
 */
public class Driver {

    //region Fields

    private String mName;

    //endregion

    //region Properties

    public String getName() {
        return mName;
    }

    //endregion

    //region Constructors

    public Driver(String name) {
        mName = name;
    }
    //endregion
}
