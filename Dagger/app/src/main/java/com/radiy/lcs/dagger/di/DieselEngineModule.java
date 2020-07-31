package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.DieselEngine;
import com.radiy.lcs.dagger.model.Engine;
import com.radiy.lcs.dagger.model.PetrolEngine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {

    //region Fields

    private int mHorsePower;

    //endregion

    //region Constructors

    public DieselEngineModule(int horsePower) {
        mHorsePower = horsePower;
    }

    //endregion

    //region Methods

    @Provides
    Engine provideEngine(){
        return new DieselEngine(mHorsePower);
    }

    //endregion
}
