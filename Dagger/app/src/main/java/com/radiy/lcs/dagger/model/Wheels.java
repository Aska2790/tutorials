package com.radiy.lcs.dagger.model;

/**
 * we don`t own this class
 */
public class Wheels {

    //region Fields

    private Rims mRims;
    private Tires mTires;

    //endregion

    //region Constructors

    public Wheels(Rims rims, Tires tires) {
        mRims = rims;
        mTires = tires;
    }

    //endregion
}
