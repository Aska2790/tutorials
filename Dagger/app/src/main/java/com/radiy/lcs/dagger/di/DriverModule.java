package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.Driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DriverModule {

    //region Fields

    private String mName;

    //endregion

    //region Constructors

    public DriverModule(String name) {
        mName = name;
    }

    //endregion

    //region Methods

    @Provides
    @Singleton
    Driver provideDriver(){
        return new Driver(mName);
    }

    //endregion

}
