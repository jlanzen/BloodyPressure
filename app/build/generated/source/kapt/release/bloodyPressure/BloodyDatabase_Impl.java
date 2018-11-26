package bloodyPressure;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class BloodyDatabase_Impl extends BloodyDatabase {
  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BloodPressure` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `systolic` INTEGER, `diastolic` INTEGER, `pulse` INTEGER, `created` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"65b13993fd8d2ea6aae4dce6f1104607\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `BloodPressure`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBloodPressure = new HashMap<String, TableInfo.Column>(5);
        _columnsBloodPressure.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsBloodPressure.put("systolic", new TableInfo.Column("systolic", "INTEGER", false, 0));
        _columnsBloodPressure.put("diastolic", new TableInfo.Column("diastolic", "INTEGER", false, 0));
        _columnsBloodPressure.put("pulse", new TableInfo.Column("pulse", "INTEGER", false, 0));
        _columnsBloodPressure.put("created", new TableInfo.Column("created", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBloodPressure = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBloodPressure = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBloodPressure = new TableInfo("BloodPressure", _columnsBloodPressure, _foreignKeysBloodPressure, _indicesBloodPressure);
        final TableInfo _existingBloodPressure = TableInfo.read(_db, "BloodPressure");
        if (! _infoBloodPressure.equals(_existingBloodPressure)) {
          throw new IllegalStateException("Migration didn't properly handle BloodPressure(bloodyPressure.BloodPressure).\n"
                  + " Expected:\n" + _infoBloodPressure + "\n"
                  + " Found:\n" + _existingBloodPressure);
        }
      }
    }, "65b13993fd8d2ea6aae4dce6f1104607", "8018d903472ebdcafaa0d74e14427ec6");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "BloodPressure");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `BloodPressure`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }
}
