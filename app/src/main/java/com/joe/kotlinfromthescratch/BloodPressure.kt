package bloodyPressure

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey


@Entity
    data class BloodPressure(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "systolic") var systolic: Int,
    @ColumnInfo(name = "diastolic") var diastolic: Int,
    @ColumnInfo(name = "pulse") var pulse: Int,
    @ColumnInfo(name = "created") var created : Long? = System.currentTimeMillis())
{

    @Ignore
    constructor(systolic: Int, diastolic: Int, pulse: Int) : this(null, systolic, diastolic, pulse, System.currentTimeMillis())

}




