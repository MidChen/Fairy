package com.cc.fairy.view.fragment

import com.cc.fairy.base.BaseFragment
import com.cc.fairy.databinding.FragmentUserBinding

class UserFragment : BaseFragment<FragmentUserBinding>() {

    override fun viewBinding(): FragmentUserBinding {
        return FragmentUserBinding.inflate(layoutInflater)
    }

    override fun bindingView() {

    }

}