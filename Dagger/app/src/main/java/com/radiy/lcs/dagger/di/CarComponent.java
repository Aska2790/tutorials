package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.MainActivity;
import com.radiy.lcs.dagger.model.Car;

import dagger.Component;

@Component(modules = {
        WheelsModule.class
})
public interface CarComponent {

    Car getCar();

    void inject(MainActivity mainActivity);
}
