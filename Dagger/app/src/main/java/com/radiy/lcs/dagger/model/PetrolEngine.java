package com.radiy.lcs.dagger.model;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {

    //region Fields

    private int mHorsePower;
    private int mEngineCapacity;

    //endregion

    //region Constructors

    @Inject
    public PetrolEngine(@Named("horsePower")int horsePower, @Named("engineCapacity") int engineCapacity) {
        mHorsePower = horsePower;
        mEngineCapacity = engineCapacity;
        Log.d(Constant.TAG, String.format("PetrolEngine created %s with %s power with %s capacity", this, mHorsePower, mEngineCapacity));
    }

    //endregion

    //region Methods

    @Override
    public void start() {
        Log.d(Constant.TAG, "start petrol engine: ");
    }

    //endregion
}
