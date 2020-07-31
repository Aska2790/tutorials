package com.radiy.lcs.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.radiy.lcs.dagger.di.CarComponent;
import com.radiy.lcs.dagger.di.DaggerCarComponent;
import com.radiy.lcs.dagger.model.Car;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent component = DaggerCarComponent.create();
        Car car = component.getCar();
        car.drive();
    }
}
