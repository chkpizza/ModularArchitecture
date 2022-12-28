package com.antique_boss.modulararchitecutre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.antique_boss.transition.Transition
import com.antique_boss.util.ConnectivityMonitor
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {
    private val appViewModel by lazy { ViewModelProvider(this).get(AppViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as GlobalApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = supportFragmentManager.findFragmentById(R.id.fragment_container)?.findNavController()
        navController?.let {
            val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
            bottomNav.setupWithNavController(it)
            it.addOnDestinationChangedListener { _, destination, _ ->
                when(destination.id) {
                    com.antique_boss.home.R.id.homeFragment -> bottomNav.visibility = View.VISIBLE
                    com.antique_boss.mypage.R.id.myPageFragment -> bottomNav.visibility = View.VISIBLE
                    else -> bottomNav.visibility = View.GONE
                }
            }
        }

        observeTransition()
        observeConnectivity()
    }

    private fun observeTransition() {
        Transition.auth.observe(this) {
            val navController = supportFragmentManager.findFragmentById(R.id.fragment_container)?.findNavController()
            navController?.navigate(R.id.action_global_main)
        }
    }

    private fun observeConnectivity() {
        val rootContainer = findViewById<ConstraintLayout>(R.id.root_container)
        val snackBar = Snackbar.make(rootContainer, "네트워크 연결이 불안정합니다.", Snackbar.LENGTH_INDEFINITE)

        appViewModel.isOnline.observe(this) {
            if(!it) {
                snackBar.show()
            } else {
                snackBar.dismiss()
            }
        }
        appViewModel.makeConnectivityMonitor(applicationContext)
    }
}