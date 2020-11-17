package com.aska.development.mvvmkotlin.model.room

import androidx.room.RoomDatabase

abstract class CreatureDatabase : RoomDatabase() {
    abstract fun creatureDao(): CreatureDao
}