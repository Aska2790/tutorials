package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.Driver;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DriverModule.class})
public interface AppComponent {

    Driver getDriver();
}
