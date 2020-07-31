package com.radiy.lcs.dagger.model;

import android.util.Log;

import javax.inject.Inject;

public class Car {

    //region Fields

    private Wheels mWheels;
    private Engine mEngine;

    //endregion

    //region Constructors

    @Inject
    public Car(Engine engine, Wheels wheels) {
        mWheels = wheels;
        mEngine = engine;
        Log.d(Constant.TAG, "Car dependencies injected: " +  this);
    }

    //endregion

    //region Methods

    public void drive(){
        Log.d(Constant.TAG, "drive: ");
    }

    //endregion
}
