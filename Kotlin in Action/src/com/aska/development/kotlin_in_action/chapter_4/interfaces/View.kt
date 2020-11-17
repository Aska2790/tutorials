package com.aska.development.kotlin_in_action.chapter_4.interfaces

import com.aska.development.kotlin_in_action.chapter_4.interfaces.State

interface View {

    val displayName:String

    fun getCurrentState(): State

    fun restoreState(state: State)
}