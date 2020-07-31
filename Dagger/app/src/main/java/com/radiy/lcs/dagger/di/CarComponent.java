package com.radiy.lcs.dagger.di;

import com.radiy.lcs.dagger.model.Car;

import dagger.Component;

@Component
public interface CarComponent {
    Car getCar();
}
