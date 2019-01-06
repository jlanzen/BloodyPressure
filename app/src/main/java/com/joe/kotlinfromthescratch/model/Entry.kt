package com.joe.kotlinfromthescratch.model

import java.text.SimpleDateFormat
import java.util.*

class Entry {

    var createdDate : String
    var createdTime : String
    var systolic : Int
    var diastolic : Int
    var pulse : Int

    constructor(created : Long,  systolic : Int, diastolic : Int, pulse : Int) {
        val sdfDate = SimpleDateFormat("MM/dd/yyyy")
        val sdfTime = SimpleDateFormat("hh:mm")
        this.createdDate = sdfDate.format(Date(created!!))
        this.createdTime = sdfTime.format(Date(created!!))
        this.systolic = systolic
        this.diastolic = diastolic
        this.pulse = pulse
    }

    constructor(createdDate : String, createdTime : String,  systolic : Int, diastolic : Int, pulse : Int) {
        this.createdDate = createdDate
        this.createdTime = createdTime
        this.systolic = systolic
        this.diastolic = diastolic
        this.pulse = pulse
    }


}

