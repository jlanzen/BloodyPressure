package com.joe.kotlinfromthescratch.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.EditText
import android.widget.ImageButton
import bloodyPressure.BloodPressure
import bloodyPressure.BloodPressureDao
import bloodyPressure.BloodyDatabase
import com.joe.kotlinfromthescratch.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import org.jetbrains.anko.doAsync

class AddActivity : AppCompatActivity() {

    private var db: BloodyDatabase? = null
    private var bloodPressureDao: BloodPressureDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_layout)

        db = BloodyDatabase.getAppDataBase(context = this)
        bloodPressureDao = db?.bloodPressureDao()


        // get reference to button
        val btn_save_blood_pressure = findViewById(R.id.saveBloodPressure) as ImageButton

        // set on-click listener

        btn_save_blood_pressure.setOnClickListener {

            val sys : Int = (findViewById(R.id.systolicValue) as EditText).text.toString().toInt()
            val dys : Int = (findViewById(R.id.diastolicValue) as EditText).text.toString().toInt()
            val pul : Int = (findViewById(R.id.pulseValue) as EditText).text.toString().toInt()

            doAsync {
                db?.bloodPressureDao()?.insertAll(BloodPressure(sys, dys, pul))

                val allItems = db?.bloodPressureDao()?.getAllByTimestamp()
            }

            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)

        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.menu.getItem(0).isChecked = true

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
                val intent = Intent(this, ListActivity::class.java).apply {}
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
