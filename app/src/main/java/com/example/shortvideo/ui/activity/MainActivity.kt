package com.example.shortvideo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.shortvideo.R
import com.example.shortvideo.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : BaseActivity() {

    companion object{
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
    }

    private fun initComponent(){
        val bottomNavigation =
            findViewById<BottomNavigationView>(R.id.main_bottomNavigationView)

        val navController: NavController =
            Navigation.findNavController(this, R.id.main_nav_host_fragment)

        NavigationUI.setupWithNavController(bottomNavigation, navController)
    }


}