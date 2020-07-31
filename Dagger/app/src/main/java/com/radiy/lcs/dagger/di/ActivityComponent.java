package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.MainActivity;
import com.radiy.lcs.dagger.model.Car;
import com.radiy.lcs.dagger.model.DieselEngine;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {
        WheelsModule.class,
        DieselEngineModule.class
})
public interface ActivityComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

//    @Component.Builder
//    interface Builder{
//
//        @BindsInstance
//        Builder horsePower(@Named("horsePower") int horsePower);
//
//        @BindsInstance
//        Builder engineCapacity(@Named("engineCapacity") int engineCapacity);
//
//        Builder appComponent(AppComponent appComponent);
//
//        ActivityComponent build();
//
//
//    }
}
