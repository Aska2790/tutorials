package com.aska.development.kotlin_in_action.chapter_4.interfaces

interface Focusable {

    fun setFocus(value: Boolean) =
        println("I ${if(value) "got" else "lost"} focus")

    fun showOff() =
        println("I`m focusable!")
}