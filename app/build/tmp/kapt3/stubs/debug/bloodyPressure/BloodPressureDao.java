package bloodyPressure;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"LbloodyPressure/BloodPressureDao;", "", "delete", "", "bloodPressure", "LbloodyPressure/BloodPressure;", "getAll", "", "getAllByTimestamp", "insertAll", "vararg", "app_debug"})
public abstract interface BloodPressureDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM BloodPressure")
    public abstract java.util.List<bloodyPressure.BloodPressure> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM BloodPressure ORDER BY created DESC")
    public abstract java.util.List<bloodyPressure.BloodPressure> getAllByTimestamp();
    
    @android.arch.persistence.room.Insert()
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    bloodyPressure.BloodPressure vararg);
    
    @android.arch.persistence.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    bloodyPressure.BloodPressure bloodPressure);
}