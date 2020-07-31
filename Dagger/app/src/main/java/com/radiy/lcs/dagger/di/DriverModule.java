package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.Driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class DriverModule {

    @Provides
    @Singleton
    static Driver provideDriver(){
        return new Driver();
    }

}
