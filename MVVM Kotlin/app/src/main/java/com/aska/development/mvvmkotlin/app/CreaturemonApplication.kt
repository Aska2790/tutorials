package com.aska.development.mvvmkotlin.app

import android.app.Application
import com.aska.development.mvvmkotlin.model.room.CreatureDatabase

class CreaturemonApplication : Application(){
    companion object {
        lateinit var database: CreatureDatabase
    }

    override fun onCreate() {
        super.onCreate()
        // TODO: init database
    }
}