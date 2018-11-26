package bloodyPressure;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class BloodPressureDao_Impl implements BloodPressureDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfBloodPressure;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfBloodPressure;

  public BloodPressureDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBloodPressure = new EntityInsertionAdapter<BloodPressure>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BloodPressure`(`id`,`systolic`,`diastolic`,`pulse`,`created`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BloodPressure value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getSystolic());
        stmt.bindLong(3, value.getDiastolic());
        stmt.bindLong(4, value.getPulse());
        if (value.getCreated() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCreated());
        }
      }
    };
    this.__deletionAdapterOfBloodPressure = new EntityDeletionOrUpdateAdapter<BloodPressure>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `BloodPressure` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BloodPressure value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public void insertAll(BloodPressure vararg) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfBloodPressure.insert(vararg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(BloodPressure bloodPressure) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfBloodPressure.handle(bloodPressure);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<BloodPressure> getAll() {
    final String _sql = "SELECT * FROM BloodPressure";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfSystolic = _cursor.getColumnIndexOrThrow("systolic");
      final int _cursorIndexOfDiastolic = _cursor.getColumnIndexOrThrow("diastolic");
      final int _cursorIndexOfPulse = _cursor.getColumnIndexOrThrow("pulse");
      final int _cursorIndexOfCreated = _cursor.getColumnIndexOrThrow("created");
      final List<BloodPressure> _result = new ArrayList<BloodPressure>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BloodPressure _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpSystolic;
        _tmpSystolic = _cursor.getInt(_cursorIndexOfSystolic);
        final int _tmpDiastolic;
        _tmpDiastolic = _cursor.getInt(_cursorIndexOfDiastolic);
        final int _tmpPulse;
        _tmpPulse = _cursor.getInt(_cursorIndexOfPulse);
        final Long _tmpCreated;
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _tmpCreated = null;
        } else {
          _tmpCreated = _cursor.getLong(_cursorIndexOfCreated);
        }
        _item = new BloodPressure(_tmpId,_tmpSystolic,_tmpDiastolic,_tmpPulse,_tmpCreated);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<BloodPressure> getAllByTimestamp() {
    final String _sql = "SELECT * FROM BloodPressure ORDER BY created DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfSystolic = _cursor.getColumnIndexOrThrow("systolic");
      final int _cursorIndexOfDiastolic = _cursor.getColumnIndexOrThrow("diastolic");
      final int _cursorIndexOfPulse = _cursor.getColumnIndexOrThrow("pulse");
      final int _cursorIndexOfCreated = _cursor.getColumnIndexOrThrow("created");
      final List<BloodPressure> _result = new ArrayList<BloodPressure>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BloodPressure _item;
        final Integer _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getInt(_cursorIndexOfId);
        }
        final int _tmpSystolic;
        _tmpSystolic = _cursor.getInt(_cursorIndexOfSystolic);
        final int _tmpDiastolic;
        _tmpDiastolic = _cursor.getInt(_cursorIndexOfDiastolic);
        final int _tmpPulse;
        _tmpPulse = _cursor.getInt(_cursorIndexOfPulse);
        final Long _tmpCreated;
        if (_cursor.isNull(_cursorIndexOfCreated)) {
          _tmpCreated = null;
        } else {
          _tmpCreated = _cursor.getLong(_cursorIndexOfCreated);
        }
        _item = new BloodPressure(_tmpId,_tmpSystolic,_tmpDiastolic,_tmpPulse,_tmpCreated);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
