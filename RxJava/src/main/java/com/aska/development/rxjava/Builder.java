package com.aska.development.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;

public class Builder {


    public static void just(){
        System.out.println("Just builder");

        final Observable<String> just = Observable.just("A", "B", "C");
        just.subscribe(System.out::println);
    }

    public static void from(){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable.fromArray(letters)
        .subscribe(System.out::println);
    }



}
