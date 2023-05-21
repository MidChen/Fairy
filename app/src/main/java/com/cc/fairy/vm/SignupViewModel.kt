package com.cc.fairy.vm

import androidx.lifecycle.ViewModel
import com.cc.fairy.model.ResultModel
import com.cc.fairy.model.UserModel
import com.cc.fairy.remote.FairyHttp

class SignupViewModel : ViewModel() {

    suspend fun login(map: Map<String, String>) : ResultModel<UserModel> {
        return FairyHttp.api().login(map)
    }

}