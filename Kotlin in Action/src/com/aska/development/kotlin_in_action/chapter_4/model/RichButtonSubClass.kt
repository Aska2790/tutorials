package com.aska.development.kotlin_in_action.chapter_4.model

class RichButtonSubClass : RichButton() {
    override fun showOff() {
        println("override showOff method in ${RichButtonSubClass::class.simpleName}")
    }
}