package com.joe.bloodypressure.activities

import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import bloodyPressure.BloodPressureDao
import bloodyPressure.BloodyDatabase
import com.joe.bloodypressure.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*

open class BloodyPressureBaseActivity : AppCompatActivity() {

    protected var db: BloodyDatabase? = null
    protected var bloodPressureDao: BloodPressureDao? = null

    init {
        db = BloodyDatabase.getAppDataBase(context = this)
        bloodPressureDao = db?.bloodPressureDao()
    }


    protected val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

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
    protected fun setNavigationState(index : Int){
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.menu.getItem(index).isChecked = true
    }
}