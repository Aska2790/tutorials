package com.aska.development.kotlin_in_action.chapter_4

interface Logger{

    fun log(message:String){
        println("I`m log method in ${Logger::class.simpleName}")
        println(message)
    }
}