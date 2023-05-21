package com.cc.fairy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<VB: ViewBinding> : DialogFragment() {

    private lateinit var _vb: VB
    protected val vb get() = _vb

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 是否允许点空白取消
        dialog?.setCanceledOnTouchOutside(false)
        _vb = viewBinding()
        bindingView()
        return _vb.root
    }

    abstract fun viewBinding(): VB

    abstract fun bindingView()

}