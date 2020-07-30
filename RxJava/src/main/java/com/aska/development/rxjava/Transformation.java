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

    public static void scan(){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable.fromArray(letters)
                .scan((x, y) -> x + y)
                .subscribe(next -> {
                    System.out.println("Scan next " + next);
                }, throwable -> {
                    throwable.printStackTrace();
                }, () -> {
                    System.out.println("Scan complete");
                });
    }

}
