package com.cc.fairy.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cc.fairy.database.dao.UserDao
import com.cc.fairy.database.entity.User

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class FairyDatabase : RoomDatabase() {

    companion object {

        @Synchronized
        fun instance(context: Context): FairyDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                FairyDatabase::class.java,
                "fairy"
            ).build()
        }
    }

    abstract fun userDao(): UserDao

}