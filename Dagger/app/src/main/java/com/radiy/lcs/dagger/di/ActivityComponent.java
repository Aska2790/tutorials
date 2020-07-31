package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.MainActivity;
import com.radiy.lcs.dagger.model.Car;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {
        WheelsModule.class,
        PetrolEngineModule.class
})
public interface ActivityComponent {

    Car getCar();

    void inject(MainActivity mainActivity);

    @Subcomponent.Factory
    interface Factory{
        ActivityComponent create(@BindsInstance @Named("horsePower") int horsePower,
                                 @BindsInstance @Named("engineCapacity") int engineCapacity);
    }
}
