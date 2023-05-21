package com.cc.fairy.view.dialog

import com.cc.fairy.base.BaseDialogFragment
import com.cc.fairy.databinding.DialogLoadingBinding

class LoadingDialog : BaseDialogFragment<DialogLoadingBinding>() {

    override fun viewBinding(): DialogLoadingBinding {
        return DialogLoadingBinding.inflate(layoutInflater)
    }

    override fun bindingView() {
        vb.textview.text = "正在加载中..."
    }
}