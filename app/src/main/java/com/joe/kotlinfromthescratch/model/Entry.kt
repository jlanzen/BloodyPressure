package com.joe.kotlinfromthescratch.model

import java.text.SimpleDateFormat
import java.util.*

class Entry(val createdDate : String, val createdTime : String,  val systolic : Int, val diastolic : Int, val pulse : Int) {

    constructor(created : Long,  systolic : Int, diastolic : Int, pulse : Int) :
            this(calculateDate(created), calculateTime(created), systolic, diastolic, pulse)
}

fun calculateDate(created: Long): String {
    val sdfDate = SimpleDateFormat("dd.MM.yyyy")
    return sdfDate.format(Date(created!!))
}

fun calculateTime(created: Long): String {
    val sdfTime = SimpleDateFormat("hh:mm")
    return sdfTime.format(Date(created!!))
}

