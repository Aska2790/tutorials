package com.aska.development.kotlin_in_action.chapter_4.model

import com.aska.development.kotlin_in_action.chapter_4.base.Animated
import com.aska.development.kotlin_in_action.chapter_4.interfaces.Clickable
import com.aska.development.kotlin_in_action.chapter_4.interfaces.Focusable
import com.aska.development.kotlin_in_action.chapter_4.interfaces.State
import com.aska.development.kotlin_in_action.chapter_4.interfaces.View

open class Button : Animated(), View,
    Clickable, Focusable {

    private val buttonState: ButtonState =
        ButtonState()

    override val displayName: String
        get() = TODO("Not yet implemented")

    /**
     * Реализация интерфейса Clickable
     * */
    override fun click() {
        println("${Button::class.simpleName} clicked")
    }

    /**
     * Реализация метода при наличия одинакового метода в двух интерфейсах
     * */
    override fun showOff() {
        println("I`m showOff method in ${Button::class.simpleName}")
    }

    override fun animate() {
        println("I`m animate method in ${Button::class.simpleName}")
    }

    override fun stopAnimating() {
        super<Animated>.stopAnimating()
        println("I`m stopAnimating method in ${Button::class.simpleName}")
    }

    override fun getCurrentState(): State {
        return buttonState
    }

    override fun restoreState(state: State) {

    }

    fun getDebugInfo(): Debug {
        return Debug()
    }

    /**
     * Вложенный класс состояния кнопки
     * */
    class ButtonState : State {

    }

    /**
     * Внутренний класс кнопки
     * */
    inner class Debug {
        fun getOuterReference(): Button = this@Button
    }
}