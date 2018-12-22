package bloodyPressure

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(BloodPressure::class), version = 1)
abstract class BloodyDatabase : RoomDatabase() {

    abstract fun bloodPressureDao(): BloodPressureDao
    companion object {
        var INSTANCE: BloodyDatabase? = null

        fun getAppDataBase(context: Context): BloodyDatabase? {
            if (INSTANCE == null){
                synchronized(BloodyDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, BloodyDatabase::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}