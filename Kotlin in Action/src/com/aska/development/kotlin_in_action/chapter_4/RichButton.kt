package com.aska.development.kotlin_in_action.chapter_4

/**
 * Открытый класс доступный для наследования
 * */
open class RichButton : Clickable, Focusable {

    /**
     * Реализация интерфейса Clickable
     * Метод доступен для переопределения в подклассах
     * */
    override fun click() {
        println("${RichButton::class.simpleName} clicked")
    }

    /**
     * Переопределение метода по умолчанию с интерфейса Focusable
     * Метод недоступен для переопределения в подклассах
     * */
    final override fun setFocus(value: Boolean) {
        super.setFocus(value)
    }

    /**
     * Реализация метода при наличия одинакового метода в двух интерфейсах
     * */
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

    /**
     * Закрытый метод недоступный для переопределения в подклассах
     * */
    fun disable(){
        println("I`m disable method in ${RichButton::class.simpleName}")
    }

    /**
     * Открытый метод доступный для переопределения в подклассах
     * */
    open fun animate(){
        println("I`m animate method in ${RichButton::class.simpleName}")
    }


}