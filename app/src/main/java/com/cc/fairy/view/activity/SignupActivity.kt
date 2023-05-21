package com.cc.fairy.view.activity

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.cc.fairy.base.BaseActivity
import com.cc.fairy.databinding.ActivitySignupBinding
import com.cc.fairy.view.dialog.LoadingDialog
import com.cc.fairy.vm.SignupViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class SignupActivity : BaseActivity<ActivitySignupBinding>() {

    private val viewModel: SignupViewModel by viewModels()
    private lateinit var loadingDialog: LoadingDialog

    override fun viewBinding(): ActivitySignupBinding {
        return ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun bindingView() {

        loadingDialog = LoadingDialog()
        val map = mapOf(
            "username" to "cc870825",
            "password" to "cc870825",
        )

        lifecycleScope.launch {
            flow {
                emit(viewModel.login(map))
            }.onStart {
                loadingDialog.show(supportFragmentManager,"loading")
            }.onCompletion {
                loadingDialog.dismiss()
            }.catch { e->
                Log.e("异常", e.message.toString())
            }.collect {

            }
        }
    }

}