package com.aska.development.kotlin_in_action.chapter_4

/**
 * Без модификатора internal ошибка компиляции
 * функция-расширения расскрывает класс(узкая область видимости)
 * */
internal fun TalkativeButton.giveSpeech(){
    // yell() Не доступно private
    // whisper() Не доступно protected
    setFocus(true)
}