package com.aska.development.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class Transformation {

    public static void map() {

        System.out.println("Map transformation");
        String[] letters = new String[]{"a", "b", "c", "d"};

        Observable.fromArray(letters)
                .map(String::toUpperCase)
                .subscribe(
                        letter -> {
                            System.out.println("Map next " + letter);
                        }, throwable -> {
                            throwable.printStackTrace();
                        }, () -> {
                            System.out.println("Map complete");
                        });


    }

    public static void flatMap(){
        System.out.println("FlatMap transformation");
        
    }

}
