package com.aska.development.kotlin_in_action.chapter_4.util

/**
 * Основной конструктор
 * */
open class User constructor(_nickname: String) {

    val nickname: String
    var address: String = "null"
        get() {
            return field
        }
        private set(value) {
            field = value
        }

    /**
     * Блок инициализации
     * */
    init {
        this.nickname = _nickname;
    }
}

/**
 * Основной конструктор с параметром
 * */
class User1 constructor(_nickname: String) {

    /**
     * Инициализация свойства параметром конструктора
     * */
    val nickname: String = _nickname
}

/**
 * Создание свойства на основе переданного параметра
 * */
class User2 constructor(val nickname: String)

/**
 * Сокращенная запись создание класса
 * */
open class User3(val nickname: String, val isSubscribed: Boolean = false)

class TwitterUser(nickname: String) : User3(nickname)