package com.cc.fairy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    private lateinit var _vb: VB
    protected val vb get() = _vb

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vb = viewBinding()
        bindingView()
        return _vb.root
    }

    abstract fun viewBinding(): VB

    abstract fun bindingView()

}