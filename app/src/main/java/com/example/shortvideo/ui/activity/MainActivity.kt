package com.example.shortvideo.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.shortvideo.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    companion object{
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<BottomNavigationView>(R.id.main_bottomNavigationView)
        val navController: NavController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(navigation, navController)
        navigation.setOnItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homePageFragment -> return@OnNavigationItemSelectedListener true
                R.id.shortVideoFragment -> return@OnNavigationItemSelectedListener true
                R.id.messageFragment -> return@OnNavigationItemSelectedListener true
                R.id.mineFragment -> return@OnNavigationItemSelectedListener true
            }
            false
        })
    }


}