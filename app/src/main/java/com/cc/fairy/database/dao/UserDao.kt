package com.cc.fairy.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cc.fairy.database.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insert(vararg user: User)

    @Query("SELECT * FROM user")
    fun query(): Flow<List<User>>

}