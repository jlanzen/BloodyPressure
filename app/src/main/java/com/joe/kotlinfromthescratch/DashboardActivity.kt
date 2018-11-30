package com.joe.kotlinfromthescratch

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ImageButton
import bloodyPressure.BloodPressure
import bloodyPressure.BloodPressureDao
import bloodyPressure.BloodyDatabase
import org.jetbrains.anko.doAsync

class DashboardActivity : AppCompatActivity() {

    private var db: BloodyDatabase? = null
    private var bloodPressureDao: BloodPressureDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.save_pressuer)

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

            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)

        }

    }

}
