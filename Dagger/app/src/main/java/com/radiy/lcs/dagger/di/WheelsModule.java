package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.Rims;
import com.radiy.lcs.dagger.model.Tires;
import com.radiy.lcs.dagger.model.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {

    @Provides
    Rims provideRims(){
        return new Rims();
    }

    @Provides
    Tires provideTires(){
        Tires tires = new Tires();
        tires.initialization();
        return tires;
    }

    @Provides
    Wheels provideWheels(Rims rims, Tires tires){
        return new Wheels(rims, tires);
    }
}
