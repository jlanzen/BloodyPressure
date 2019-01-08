package com.joe.kotlinfromthescratch.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import com.joe.kotlinfromthescratch.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries


class GraphActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graph_layout)

        val graph = findViewById<View>(R.id.graph) as GraphView
        val series = LineGraphSeries(
            arrayOf<DataPoint>(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        graph.addSeries(series)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigation.menu.getItem(2).isChecked = true
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
