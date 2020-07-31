package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.DieselEngine;
import com.radiy.lcs.dagger.model.Engine;
import com.radiy.lcs.dagger.model.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    @Binds
    abstract Engine bindEngine(DieselEngine engine);
}
