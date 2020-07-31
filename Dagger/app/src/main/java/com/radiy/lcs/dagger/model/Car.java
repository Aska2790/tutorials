package com.radiy.lcs.dagger.model;

import android.util.Log;

import com.radiy.lcs.dagger.di.PerActivity;

import javax.inject.Inject;

@PerActivity
public class Car {

    //region Fields

    private Driver mDriver;
    private Wheels mWheels;
    private Engine mEngine;

    //endregion

    @Inject
    public void setWheels(Wheels wheels) {
        mWheels = wheels;
        Log.d(Constant.TAG, "Car wheels injected: " +  wheels);
    }

    @Inject
    public void setEngine(Engine engine) {
        mEngine = engine;
        Log.d(Constant.TAG, "Car engine injected: " +  engine);
    }


    //region Constructors

    @Inject
    public Car(Driver driver) {
        mDriver = driver;
        Log.d(Constant.TAG, "Car created " +  this);
    }

    //endregion

    //region Methods

    public void drive(){
        mEngine.start();
        Log.d(Constant.TAG, String.format("drive %s car with driver %s: ", this, mDriver));
    }

    @Inject
    public void enableRemoteControl(RemoteControl remoteControl){
        Log.d(Constant.TAG, "RemoteControl injected " +  remoteControl);
        remoteControl.setControl(this);
    }
    //endregion
}
