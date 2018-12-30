package com.joe.kotlinfromthescratch.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.joe.kotlinfromthescratch.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_layout)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.menu.getItem(3).isChecked = true
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val menu: Menu = bottom_navigation.menu

        when (item.itemId) {
            R.id.menu_action_add -> {
                val intent = Intent(this, AddActivity::class.java).apply {}
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_action_graph -> {
                val intent = Intent(this, GraphActivity::class.java).apply {}
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_action_list -> {
                val intent = Intent(this, EntryListActivity::class.java).apply {}
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java).apply {}
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
