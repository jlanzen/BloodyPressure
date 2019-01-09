package com.joe.bloodypressure.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.View
import bloodyPressure.BloodPressure
import bloodyPressure.BloodPressureDao
import bloodyPressure.BloodyDatabase
import com.joe.bloodypressure.R
import kotlinx.android.synthetic.main.bottom_navigation_layout.*
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import org.jetbrains.anko.doAsync


class GraphActivity : BloodyPressureBaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.graph_layout)
        setNavigationState(2)

        doAsync {
            val allItems = db?.bloodPressureDao()?.getAllByTimestamp()
            var systolicArrayList : ArrayList<DataPoint> = ArrayList<DataPoint>()
            var diastolicArrayList : ArrayList<DataPoint> = ArrayList<DataPoint>()
            var pulseArrayList : ArrayList<DataPoint> = ArrayList<DataPoint>()
            if (allItems != null) {
                var i : Int = 0
                for (bp : BloodPressure in allItems) {
                    systolicArrayList.add(DataPoint(i.toDouble(), bp.systolic.toDouble()))
                    diastolicArrayList.add(DataPoint(i.toDouble(), bp.diastolic.toDouble()))
                    pulseArrayList.add(DataPoint(i.toDouble(), bp.pulse.toDouble()))
                    i++
                }
            }
            val graph = findViewById<View>(R.id.graph) as GraphView
            var systolicSeries : LineGraphSeries<DataPoint> = LineGraphSeries(systolicArrayList.toTypedArray())
            systolicSeries.color = Color.GREEN
            systolicSeries.backgroundColor = Color.TRANSPARENT
            var diastolicSeries : LineGraphSeries<DataPoint> = LineGraphSeries(diastolicArrayList.toTypedArray())
            diastolicSeries.color = Color.RED
            diastolicSeries.backgroundColor = Color.TRANSPARENT
            var pulseSeries : LineGraphSeries<DataPoint> = LineGraphSeries(pulseArrayList.toTypedArray())
            pulseSeries.color = Color.BLUE
            pulseSeries.backgroundColor = Color.TRANSPARENT

            graph.addSeries(systolicSeries)
            graph.addSeries(diastolicSeries)
            graph.addSeries(pulseSeries)

        }


    }

}
