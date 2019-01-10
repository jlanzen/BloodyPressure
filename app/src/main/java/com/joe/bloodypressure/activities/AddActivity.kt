package com.joe.bloodypressure.activities

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import bloodyPressure.BloodPressure
import bloodyPressure.BloodPressureDao
import bloodyPressure.BloodyDatabase
import com.joe.bloodypressure.R
import org.jetbrains.anko.doAsync

class AddActivity : BloodyPressureBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_layout)
        setNavigationState(0)
        initDB()

        // get reference to button
        val btn_save_blood_pressure = findViewById(R.id.saveBloodPressure) as ImageButton

        // set on-click listener
        btn_save_blood_pressure.setOnClickListener {

            val sys : Int = (findViewById(R.id.systolicValue) as EditText).text.toString().toInt()
            val dys : Int = (findViewById(R.id.diastolicValue) as EditText).text.toString().toInt()
            val pul : Int = (findViewById(R.id.pulseValue) as EditText).text.toString().toInt()

            doAsync {
                db?.bloodPressureDao()?.insertAll(BloodPressure(sys, dys, pul))
            }

            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)

        }

    }

}
