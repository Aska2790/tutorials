package com.radiy.lcs.dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.radiy.lcs.dagger.di.ActivityComponent;
import com.radiy.lcs.dagger.di.AppComponent;
import com.radiy.lcs.dagger.di.DaggerActivityComponent;
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
        ActivityComponent component = DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .engineCapacity(19000)
                .horsePower(1400)
                .build();

        component.inject(this);

        mCar.drive();
        mCar2.drive();
    }
}
