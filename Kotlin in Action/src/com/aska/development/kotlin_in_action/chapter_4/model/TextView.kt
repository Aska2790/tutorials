package com.aska.development.kotlin_in_action.chapter_4.model

import com.aska.development.kotlin_in_action.chapter_4.interfaces.State
import com.aska.development.kotlin_in_action.chapter_4.interfaces.View

class TextView : View {
    override val displayName: String
        get() = "TextView"

    override fun getCurrentState(): State {
        TODO("Not yet implemented")
    }

    override fun restoreState(state: State) {
        TODO("Not yet implemented")
    }
}