package com.example.newweatherapp.databases;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.newweatherapp.models.weather.Main;
import com.example.newweatherapp.models.weather.Rain;
import com.example.newweatherapp.models.weather.Sys;
import com.example.newweatherapp.models.weather.WeatherItem;
import com.example.newweatherapp.models.weather.WeatherListItem;
import com.example.newweatherapp.models.weather.Wind;
import com.example.newweatherapp.utils.Converters;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherListItem> __insertionAdapterOfWeatherListItem;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<WeatherListItem> __deletionAdapterOfWeatherListItem;

  private final EntityDeletionOrUpdateAdapter<WeatherListItem> __updateAdapterOfWeatherListItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllSavedWeathers;

  public WeatherDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherListItem = new EntityInsertionAdapter<WeatherListItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `weather_table` (`name`,`main`,`wind`,`sys`,`rain`,`snow`,`weatherItem`,`isAdded`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherListItem value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        final String _tmp = __converters.fromMain(value.getMain());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        final String _tmp_1 = __converters.fromWind(value.getWind());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp_1);
        }
        final String _tmp_2 = __converters.fromSys(value.getSys());
        if (_tmp_2 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_2);
        }
        final String _tmp_3 = __converters.fromRain(value.getRain());
        if (_tmp_3 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_3);
        }
        if (value.getSnow() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getSnow());
        }
        final String _tmp_4 = __converters.fromWeatherItem(value.getWeatherItem());
        if (_tmp_4 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_4);
        }
        final int _tmp_5 = value.isAdded() ? 1 : 0;
        stmt.bindLong(8, _tmp_5);
      }
    };
    this.__deletionAdapterOfWeatherListItem = new EntityDeletionOrUpdateAdapter<WeatherListItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `weather_table` WHERE `name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherListItem value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
      }
    };
    this.__updateAdapterOfWeatherListItem = new EntityDeletionOrUpdateAdapter<WeatherListItem>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `weather_table` SET `name` = ?,`main` = ?,`wind` = ?,`sys` = ?,`rain` = ?,`snow` = ?,`weatherItem` = ?,`isAdded` = ? WHERE `name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherListItem value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        final String _tmp = __converters.fromMain(value.getMain());
        if (_tmp == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, _tmp);
        }
        final String _tmp_1 = __converters.fromWind(value.getWind());
        if (_tmp_1 == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp_1);
        }
        final String _tmp_2 = __converters.fromSys(value.getSys());
        if (_tmp_2 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_2);
        }
        final String _tmp_3 = __converters.fromRain(value.getRain());
        if (_tmp_3 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_3);
        }
        if (value.getSnow() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getSnow());
        }
        final String _tmp_4 = __converters.fromWeatherItem(value.getWeatherItem());
        if (_tmp_4 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, _tmp_4);
        }
        final int _tmp_5 = value.isAdded() ? 1 : 0;
        stmt.bindLong(8, _tmp_5);
        if (value.getName() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getName());
        }
      }
    };
    this.__preparedStmtOfDeleteAllSavedWeathers = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM weather_table";
        return _query;
      }
    };
  }

  @Override
  public void insertWeather(final WeatherListItem weatherToInsert) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfWeatherListItem.insert(weatherToInsert);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWeather(final WeatherListItem weatherToDelete) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfWeatherListItem.handle(weatherToDelete);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWeather(final WeatherListItem weatherToUpdate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfWeatherListItem.handle(weatherToUpdate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllSavedWeathers() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllSavedWeathers.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllSavedWeathers.release(_stmt);
    }
  }

  @Override
  public LiveData<WeatherListItem> getWeatherTable() {
    final String _sql = "SELECT * FROM weather_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"weather_table"}, false, new Callable<WeatherListItem>() {
      @Override
      public WeatherListItem call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfMain = CursorUtil.getColumnIndexOrThrow(_cursor, "main");
          final int _cursorIndexOfWind = CursorUtil.getColumnIndexOrThrow(_cursor, "wind");
          final int _cursorIndexOfSys = CursorUtil.getColumnIndexOrThrow(_cursor, "sys");
          final int _cursorIndexOfRain = CursorUtil.getColumnIndexOrThrow(_cursor, "rain");
          final int _cursorIndexOfSnow = CursorUtil.getColumnIndexOrThrow(_cursor, "snow");
          final int _cursorIndexOfWeatherItem = CursorUtil.getColumnIndexOrThrow(_cursor, "weatherItem");
          final int _cursorIndexOfIsAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "isAdded");
          final WeatherListItem _result;
          if(_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Main _tmpMain;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfMain)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfMain);
            }
            _tmpMain = __converters.toMain(_tmp);
            final Wind _tmpWind;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfWind)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfWind);
            }
            _tmpWind = __converters.toWind(_tmp_1);
            final Sys _tmpSys;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSys)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSys);
            }
            _tmpSys = __converters.toSys(_tmp_2);
            final Rain _tmpRain;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfRain)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfRain);
            }
            _tmpRain = __converters.toRain(_tmp_3);
            final Double _tmpSnow;
            if (_cursor.isNull(_cursorIndexOfSnow)) {
              _tmpSnow = null;
            } else {
              _tmpSnow = _cursor.getDouble(_cursorIndexOfSnow);
            }
            final List<WeatherItem> _tmpWeatherItem;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfWeatherItem)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfWeatherItem);
            }
            _tmpWeatherItem = __converters.toWeatherItem(_tmp_4);
            final boolean _tmpIsAdded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsAdded);
            _tmpIsAdded = _tmp_5 != 0;
            _result = new WeatherListItem(_tmpName,_tmpMain,_tmpWind,_tmpSys,_tmpRain,_tmpSnow,_tmpWeatherItem,_tmpIsAdded);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<WeatherListItem> sortNameDesc() {
    final String _sql = "SELECT * FROM weather_table ORDER BY name DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"weather_table"}, false, new Callable<WeatherListItem>() {
      @Override
      public WeatherListItem call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfMain = CursorUtil.getColumnIndexOrThrow(_cursor, "main");
          final int _cursorIndexOfWind = CursorUtil.getColumnIndexOrThrow(_cursor, "wind");
          final int _cursorIndexOfSys = CursorUtil.getColumnIndexOrThrow(_cursor, "sys");
          final int _cursorIndexOfRain = CursorUtil.getColumnIndexOrThrow(_cursor, "rain");
          final int _cursorIndexOfSnow = CursorUtil.getColumnIndexOrThrow(_cursor, "snow");
          final int _cursorIndexOfWeatherItem = CursorUtil.getColumnIndexOrThrow(_cursor, "weatherItem");
          final int _cursorIndexOfIsAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "isAdded");
          final WeatherListItem _result;
          if(_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Main _tmpMain;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfMain)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfMain);
            }
            _tmpMain = __converters.toMain(_tmp);
            final Wind _tmpWind;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfWind)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfWind);
            }
            _tmpWind = __converters.toWind(_tmp_1);
            final Sys _tmpSys;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSys)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSys);
            }
            _tmpSys = __converters.toSys(_tmp_2);
            final Rain _tmpRain;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfRain)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfRain);
            }
            _tmpRain = __converters.toRain(_tmp_3);
            final Double _tmpSnow;
            if (_cursor.isNull(_cursorIndexOfSnow)) {
              _tmpSnow = null;
            } else {
              _tmpSnow = _cursor.getDouble(_cursorIndexOfSnow);
            }
            final List<WeatherItem> _tmpWeatherItem;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfWeatherItem)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfWeatherItem);
            }
            _tmpWeatherItem = __converters.toWeatherItem(_tmp_4);
            final boolean _tmpIsAdded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsAdded);
            _tmpIsAdded = _tmp_5 != 0;
            _result = new WeatherListItem(_tmpName,_tmpMain,_tmpWind,_tmpSys,_tmpRain,_tmpSnow,_tmpWeatherItem,_tmpIsAdded);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<WeatherListItem> sortNameAsc() {
    final String _sql = "SELECT * FROM weather_table ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"weather_table"}, false, new Callable<WeatherListItem>() {
      @Override
      public WeatherListItem call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfMain = CursorUtil.getColumnIndexOrThrow(_cursor, "main");
          final int _cursorIndexOfWind = CursorUtil.getColumnIndexOrThrow(_cursor, "wind");
          final int _cursorIndexOfSys = CursorUtil.getColumnIndexOrThrow(_cursor, "sys");
          final int _cursorIndexOfRain = CursorUtil.getColumnIndexOrThrow(_cursor, "rain");
          final int _cursorIndexOfSnow = CursorUtil.getColumnIndexOrThrow(_cursor, "snow");
          final int _cursorIndexOfWeatherItem = CursorUtil.getColumnIndexOrThrow(_cursor, "weatherItem");
          final int _cursorIndexOfIsAdded = CursorUtil.getColumnIndexOrThrow(_cursor, "isAdded");
          final WeatherListItem _result;
          if(_cursor.moveToFirst()) {
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final Main _tmpMain;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfMain)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfMain);
            }
            _tmpMain = __converters.toMain(_tmp);
            final Wind _tmpWind;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfWind)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfWind);
            }
            _tmpWind = __converters.toWind(_tmp_1);
            final Sys _tmpSys;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfSys)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfSys);
            }
            _tmpSys = __converters.toSys(_tmp_2);
            final Rain _tmpRain;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfRain)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfRain);
            }
            _tmpRain = __converters.toRain(_tmp_3);
            final Double _tmpSnow;
            if (_cursor.isNull(_cursorIndexOfSnow)) {
              _tmpSnow = null;
            } else {
              _tmpSnow = _cursor.getDouble(_cursorIndexOfSnow);
            }
            final List<WeatherItem> _tmpWeatherItem;
            final String _tmp_4;
            if (_cursor.isNull(_cursorIndexOfWeatherItem)) {
              _tmp_4 = null;
            } else {
              _tmp_4 = _cursor.getString(_cursorIndexOfWeatherItem);
            }
            _tmpWeatherItem = __converters.toWeatherItem(_tmp_4);
            final boolean _tmpIsAdded;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIsAdded);
            _tmpIsAdded = _tmp_5 != 0;
            _result = new WeatherListItem(_tmpName,_tmpMain,_tmpWind,_tmpSys,_tmpRain,_tmpSnow,_tmpWeatherItem,_tmpIsAdded);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
