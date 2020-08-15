package com.aska.development.kotlin_in_action.chapter_4

open class Button : Animated(), View, Clickable, Focusable {

    private val buttonState: ButtonState = ButtonState()


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

    fun getDebugInfo():Debug{
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