package com.aska.development.kotlin_in_action.chapter_4

/**
 * Объявление простого интерфейса
 * */
interface Clickable {

    /**
     * Простое объявление метода
     * */
    fun click()

    /**
     * Метод с реализацией по умолчанию
     * */
    fun showOff() = println("I`m clickable!")
}