package com.joe.bloodypressure.activities

import android.os.Bundle
import android.widget.ListView
import bloodyPressure.BloodPressure
import bloodyPressure.BloodPressureDao
import bloodyPressure.BloodyDatabase
import com.joe.bloodypressure.R
import com.example.laj5be4.testapplication.EntryListAdapter
import com.joe.bloodypressure.model.Entry
import org.jetbrains.anko.doAsync


class EntryListActivity : BloodyPressureBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_layout)
        setNavigationState(1)

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





}
