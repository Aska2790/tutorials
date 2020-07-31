package com.radiy.lcs.dagger.model;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {

    //region Constructors

    @Inject
    public DieselEngine() {
        Log.d(Constant.TAG, "DieselEngine created " +  this);
    }

    //endregion

    //region Methods

    @Override
    public void start() {
        Log.d(Constant.TAG, "start diesel engine: ");
    }

    //endregion
}
