package com.aska.development.kotlin_in_action.chapter_4.model

import com.aska.development.kotlin_in_action.chapter_4.interfaces.Clickable

class ImageButton : Clickable {
    override fun click(){
        println("${ImageButton::class.simpleName} clicked")
    }
}