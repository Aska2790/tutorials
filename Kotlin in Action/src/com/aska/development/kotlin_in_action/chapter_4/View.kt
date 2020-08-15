package com.aska.development.kotlin_in_action.chapter_4

interface View {
    fun getCurrentState(): State
    fun restoreState(state:State)
}