package com.radiy.lcs.dagger.model;

import android.util.Log;

import javax.inject.Inject;

public class RemoteControl {

    //region Constructors

    @Inject
    public RemoteControl() {
    }

    //endregion

    //region Methods

    public void setControl(@org.jetbrains.annotations.NotNull Car car){
        Log.d(Constant.TAG, "setControl: " +  car.toString());
    }

    //endregion
}
