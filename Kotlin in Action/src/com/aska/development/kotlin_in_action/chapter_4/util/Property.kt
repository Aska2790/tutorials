package com.aska.development.kotlin_in_action.chapter_4.util

interface Property {
    val displayName: String
}

class Property1Impl : Property {

    /**
     * У свойства отсутствует поле хранящее значения
     * */
    override val displayName: String
        get() = "Property1Impl"
}

class Property2Impl(override val displayName: String):
    Property

class Property3Impl: Property {
    override val displayName: String = "Property3Impl"
}