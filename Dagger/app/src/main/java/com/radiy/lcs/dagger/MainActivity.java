package com.radiy.lcs.dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.radiy.lcs.dagger.di.ActivityComponent;
import com.radiy.lcs.dagger.di.AppComponent;
import com.radiy.lcs.dagger.di.DieselEngineModule;
import com.radiy.lcs.dagger.model.Car;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected Car mCar;

    @Inject
    protected Car mCar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppComponent appComponent = ((BaseApp) getApplication()).getAppComponent();
        ActivityComponent component = appComponent.getActivityComponent(new DieselEngineModule(100));
        component.inject(this);

        mCar.drive();
        mCar2.drive();
    }
}
