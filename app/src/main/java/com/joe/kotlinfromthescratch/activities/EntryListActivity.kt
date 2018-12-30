package com.joe.kotlinfromthescratch.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.LinearLayout
import com.joe.kotlinfromthescratch.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import android.widget.TextView


class EntryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adapter_view_layout)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.menu.getItem(1).isChecked = true

        val linearLayout = findViewById<LinearLayout>(R.id.list_layout)
        val valueTV = TextView(this)
        valueTV.setTextColor(Color.GRAY)
        valueTV.text = "hallo hallo"
        valueTV.id = 5
        valueTV.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        linearLayout.addView(valueTV)

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
