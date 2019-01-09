package com.joe.bloodypressure.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.ListView
import bloodyPressure.BloodPressure
import bloodyPressure.BloodPressureDao
import bloodyPressure.BloodyDatabase
import com.joe.bloodypressure.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import com.example.laj5be4.testapplication.EntryListAdapter
import com.joe.bloodypressure.model.Entry
import org.jetbrains.anko.doAsync


class EntryListActivity : AppCompatActivity() {

    private var db: BloodyDatabase? = null
    private var bloodPressureDao: BloodPressureDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.menu.getItem(1).isChecked = true

        db = BloodyDatabase.getAppDataBase(context = this)
        bloodPressureDao = db?.bloodPressureDao()

        val lv : ListView = findViewById(R.id.listview)

        val entryArrayList : ArrayList<Entry> = ArrayList<Entry>()


        doAsync {
            val allItems = db?.bloodPressureDao()?.getAllByTimestamp()

            if (allItems != null) {
                for (bp : BloodPressure in allItems){
                    val e : Entry = Entry(bp.created!!, bp.systolic, bp.diastolic, bp.pulse)
                    entryArrayList.add(e)
                }
            }


        }

        val entryListAdapter : EntryListAdapter = EntryListAdapter(this, R.layout.adapter_view_table_layout, entryArrayList)
        lv.adapter = entryListAdapter


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
