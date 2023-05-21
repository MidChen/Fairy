package com.cc.fairy.view.activity

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cc.fairy.base.BaseActivity
import com.cc.fairy.database.entity.User
import com.cc.fairy.databinding.ActivityUserBinding
import com.cc.fairy.vh.adapter.UserAdapter
import com.cc.fairy.vm.UserViewModel
import kotlinx.coroutines.launch

class UserActivity : BaseActivity<ActivityUserBinding>() {

    private val viewModel: UserViewModel by viewModels()

    private lateinit var userAdapter: UserAdapter

    override fun viewBinding(): ActivityUserBinding {
        return ActivityUserBinding.inflate(layoutInflater)
    }

    override fun bindingView() {

        let {
            userAdapter = UserAdapter(it)
            vb.recyclerview.apply {
                layoutManager = LinearLayoutManager(it)
                adapter = userAdapter
            }
        }

        lifecycleScope.launch {
            viewModel.query().collect {
                userAdapter.insert(it)
            }
        }

        val user = User("刘亦菲",
            "1987-08-25 08:25:00",
            "","","")
        vb.insert.setOnClickListener {
            viewModel.insert(user)
            vb.recyclerview.scrollToPosition(userAdapter.itemCount - 1)
        }

    }

}