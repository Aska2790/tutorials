package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.Engine;
import com.radiy.lcs.dagger.model.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
