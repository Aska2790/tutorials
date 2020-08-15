package com.aska.development.kotlin_in_action.chapter_4

class ImageButton : Clickable{
    override fun click(){
        println("${ImageButton::class.simpleName} clicked")
    }
}