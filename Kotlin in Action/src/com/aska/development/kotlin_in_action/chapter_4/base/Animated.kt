package com.aska.development.kotlin_in_action.chapter_4.base

/**
 * Абстрактный класс, нельзя создать экземпляры этого класса
 * */
abstract class Animated {

    /**
     * Метод который должен быть переопределен в подклассах
     * */
    abstract fun animate()

    /**
     * Метод с реализацией по умолчанию,
     * Доступный для переопределения
     * */
    open fun stopAnimating(){
        println("I`m stopAnimating method in ${Animated::class.simpleName}")
    }

    /**
     * Метод с реализацией по умолчанию,
     * Недоступный для переопределения
     * */
    fun animateTwice(){
        println("I`m animateTwice method in ${Animated::class.simpleName}")
    }
}