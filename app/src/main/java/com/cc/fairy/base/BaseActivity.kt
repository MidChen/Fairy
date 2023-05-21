package com.cc.fairy.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    private lateinit var _vb: VB
    protected val vb get() = _vb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _vb = viewBinding()
        setContentView(_vb.root)
        bindingView()
    }

    abstract fun viewBinding(): VB

    abstract fun bindingView()

}