package com.aska.development.kotlin_in_action.chapter_4.interfaces

/**
 * Объявление простого интерфейса
 * */
interface Clickable : Logger {

    /**
     * Простое объявление метода
     * */
    abstract fun click()

    /**
     * Метод с реализацией по умолчанию
     * */
    fun showOff() = println("I`m clickable!")

    /**
     * Переопределение метода по умолчанию родительского класса
     * */
    open override fun log(message: String) {
        super<Logger>.log(message)
        println("I`m log method in ${Logger::class.simpleName}")
    }
}