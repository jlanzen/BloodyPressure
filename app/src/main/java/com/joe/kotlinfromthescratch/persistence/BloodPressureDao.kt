package bloodyPressure

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface BloodPressureDao {

    @Query("SELECT * FROM BloodPressure")
    fun getAll():List<BloodPressure>

    @Query("SELECT * FROM BloodPressure ORDER BY created DESC")
    fun getAllByTimestamp():List<BloodPressure>

    @Insert
    fun insertAll(vararg: BloodPressure)

    @Delete
    fun delete(bloodPressure: BloodPressure)

}