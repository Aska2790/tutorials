package com.radiy.lcs.dagger.model;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine {

    //region Constructors

    @Inject
    public PetrolEngine() {
        Log.d(Constant.TAG, "PetrolEngine created " +  this);
    }

    //endregion

    //region Methods

    @Override
    public void start() {
        Log.d(Constant.TAG, "start petrol engine: ");
    }

    //endregion
}
