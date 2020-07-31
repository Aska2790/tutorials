package com.radiy.lcs.dagger;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.radiy.lcs.dagger.di.CarComponent;
import com.radiy.lcs.dagger.di.DaggerCarComponent;
import com.radiy.lcs.dagger.di.DieselEngineModule;
import com.radiy.lcs.dagger.model.Car;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.builder()
                .horsePower(124)
                .engineCapacity(1400)
                .build();

        component.inject(this);
        mCar.drive();
    }
}
