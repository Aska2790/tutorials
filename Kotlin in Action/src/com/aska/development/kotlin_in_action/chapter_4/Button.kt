package com.aska.development.kotlin_in_action.chapter_4

class Button : Animated(), Clickable, Focusable {

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
}