package com.joe.kotlinfromthescratch.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.widget.ListView
import com.joe.kotlinfromthescratch.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import com.example.laj5be4.testapplication.EntryListAdapter
import com.joe.kotlinfromthescratch.model.Entry


class EntryListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.menu.getItem(1).isChecked = true

        val lv : ListView = findViewById(R.id.listview)

        val e1 : Entry = Entry(10000,120, 80, 65)
        val e2 : Entry = Entry(10000,120, 80, 65)
        val e3 : Entry = Entry(10000,120, 80, 65)
        val e4 : Entry = Entry(10000,120, 80, 65)
        val e5 : Entry = Entry(10000,120, 80, 65)

        val entryArrayList : ArrayList<Entry> = ArrayList<Entry>()
        entryArrayList.add(e1)
        entryArrayList.add(e2)
        entryArrayList.add(e3)
        entryArrayList.add(e4)
        entryArrayList.add(e5)

        val entryListAdapter : EntryListAdapter = EntryListAdapter(this, R.layout.adapter_view_layout, entryArrayList)
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
