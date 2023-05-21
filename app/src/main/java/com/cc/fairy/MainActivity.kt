package com.cc.fairy

import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import com.cc.fairy.base.BaseActivity
import com.cc.fairy.databinding.ActivityMainBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun viewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun bindingView() {
        val hostView =
            supportFragmentManager.findFragmentById(R.id.hostView) as NavHostFragment
        vb.bottomView.setupWithNavController(hostView.navController)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.hostView)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}