package com.aska.development.kotlin_in_action.chapter_4

internal open class TalkativeButton :Focusable{

    private fun yell(){
        println("Hey!")
    }

    protected fun whisper(){
        println("Let`s talk")
    }

    override fun setFocus(value: Boolean) {
        super.setFocus(value)
    }
}