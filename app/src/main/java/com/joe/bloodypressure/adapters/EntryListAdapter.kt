package com.example.laj5be4.testapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.joe.bloodypressure.R
import com.joe.bloodypressure.model.Entry

class EntryListAdapter(context: Context, resource: Int, objects: ArrayList<Entry>) :
    ArrayAdapter<Entry>(context, resource, objects) {

    private var myResource : Int = 0

    init {
        myResource = resource
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val createdDate : String = getItem(position).createdDate
        val createdTime : String = getItem(position).createdTime
        val systolic : Int = getItem(position).systolic
        val diastolic : Int = getItem(position).diastolic
        val pulse : Int = getItem(position).pulse

        val entry : Entry = Entry(createdDate, createdTime,  systolic, diastolic, pulse)

        val inflater : LayoutInflater = LayoutInflater.from(context)

        var returnView : View? = convertView

        returnView = inflater.inflate(myResource, parent, false)

        val tvCreatedDate : TextView = returnView.findViewById(R.id.textView_created_date)
        val tvCreatedTime : TextView = returnView.findViewById(R.id.textView_created_time)
        val tvSystolic : TextView = returnView.findViewById(R.id.textView_systolic)
        val tvDiastolic : TextView = returnView.findViewById(R.id.textView_diastolic)
        val tvPulse : TextView = returnView.findViewById(R.id.textView_pulse)

        tvCreatedDate.text = createdDate
        tvCreatedTime.text = createdTime
        tvSystolic.text = systolic.toString()
        tvDiastolic.text = diastolic.toString()
        tvPulse.text = pulse.toString()

        return returnView

    }
}