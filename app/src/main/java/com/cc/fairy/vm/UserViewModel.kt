package com.cc.fairy.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cc.fairy.app.App
import com.cc.fairy.database.dao.UserDao
import com.cc.fairy.database.entity.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userDao: UserDao by lazy {
        App.db.userDao()
    }

    fun insert(user: User) {
        viewModelScope.launch {
            userDao.insert(user)
        }
    }

    fun query(): Flow<List<User>> {
        return userDao.query().flowOn(Dispatchers.IO)
    }

}