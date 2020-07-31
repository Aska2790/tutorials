package com.radiy.lcs.dagger;

import android.app.Application;

import com.radiy.lcs.dagger.di.AppComponent;
import com.radiy.lcs.dagger.di.DaggerAppComponent;
import com.radiy.lcs.dagger.di.DriverModule;

public class BaseApp extends Application {

    //region Fields

    private AppComponent mAppComponent;

    //endregion

    //region Lifecycle

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent =   DaggerAppComponent.factory().create(new DriverModule("Hans"));
    }

    //endregion

    //region Methods

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    //endregion
}
