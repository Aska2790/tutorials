package com.radiy.lcs.dagger.model;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {

    //region Fields

    private int mHorsePower;

    //endregion

    //region Constructors

    public DieselEngine(int horsePower) {
        mHorsePower = horsePower;
        Log.d(Constant.TAG, String.format("DieselEngine created %s with %s power",this, mHorsePower));
    }

    //endregion

    //region Methods

    @Override
    public void start() {
        Log.d(Constant.TAG, "start diesel engine: ");
    }

    //endregion
}
