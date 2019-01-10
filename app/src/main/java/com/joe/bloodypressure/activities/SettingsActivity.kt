package com.joe.bloodypressure.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.joe.bloodypressure.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*


class SettingsActivity : BloodyPressureBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_layout)
        setNavigationState(3)
        initDB()

    }

}
