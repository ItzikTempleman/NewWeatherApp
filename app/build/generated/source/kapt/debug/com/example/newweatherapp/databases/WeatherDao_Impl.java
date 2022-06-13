package com.example.newweatherapp.databases;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.newweatherapp.models.forecast.ForecastListItem;
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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDao_Impl implements WeatherDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeatherListItem> __insertionAdapterOfWeatherListItem;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<WeatherListItem> __deletionAdapterOfWeatherListItem;

  public WeatherDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeatherListItem = new EntityInsertionAdapter<WeatherListItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `weather_table` (`id`,`name`,`main`,`wind`,`sys`,`rain`,`snow`,`weatherItems`,`isSaved`,`isCurrentLocation`,`isMetric`,`forecastList`,`images`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherListItem value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        final String _tmp = __converters.fromMain(value.getMain());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
        final String _tmp_1 = __converters.fromWind(value.getWind());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp_1);
        }
        final String _tmp_2 = __converters.fromSys(value.getSys());
        if (_tmp_2 == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, _tmp_2);
        }
        final String _tmp_3 = __converters.fromRain(value.getRain());
        if (_tmp_3 == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, _tmp_3);
        }
        if (value.getSnow() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getSnow());
        }
        final String _tmp_4 = __converters.fromWeatherItem(value.getWeatherItems());
        if (_tmp_4 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, _tmp_4);
        }
        final int _tmp_5 = value.isSaved() ? 1 : 0;
        stmt.bindLong(9, _tmp_5);
        final int _tmp_6 = value.isCurrentLocation() ? 1 : 0;
        stmt.bindLong(10, _tmp_6);
        final int _tmp_7 = value.isMetric() ? 1 : 0;
        stmt.bindLong(11, _tmp_7);
        final String _tmp_8 = __converters.fromForecastList(value.getForecastList());
        if (_tmp_8 == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, _tmp_8);
        }
        final String _tmp_9 = __converters.fromImages(value.getImages());
        if (_tmp_9 == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, _tmp_9);
        }
      }
    };
    this.__deletionAdapterOfWeatherListItem = new EntityDeletionOrUpdateAdapter<WeatherListItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `weather_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, WeatherListItem value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public Object saveWeather(final WeatherListItem weatherToInsert,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWeatherListItem.insert(weatherToInsert);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object delete(final WeatherListItem weatherToInsert,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWeatherListItem.handle(weatherToInsert);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<WeatherListItem> getAllAddedWeather() {
    final String _sql = "SELECT * FROM weather_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfMain = CursorUtil.getColumnIndexOrThrow(_cursor, "main");
      final int _cursorIndexOfWind = CursorUtil.getColumnIndexOrThrow(_cursor, "wind");
      final int _cursorIndexOfSys = CursorUtil.getColumnIndexOrThrow(_cursor, "sys");
      final int _cursorIndexOfRain = CursorUtil.getColumnIndexOrThrow(_cursor, "rain");
      final int _cursorIndexOfSnow = CursorUtil.getColumnIndexOrThrow(_cursor, "snow");
      final int _cursorIndexOfWeatherItems = CursorUtil.getColumnIndexOrThrow(_cursor, "weatherItems");
      final int _cursorIndexOfIsSaved = CursorUtil.getColumnIndexOrThrow(_cursor, "isSaved");
      final int _cursorIndexOfIsCurrentLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "isCurrentLocation");
      final int _cursorIndexOfIsMetric = CursorUtil.getColumnIndexOrThrow(_cursor, "isMetric");
      final int _cursorIndexOfForecastList = CursorUtil.getColumnIndexOrThrow(_cursor, "forecastList");
      final int _cursorIndexOfImages = CursorUtil.getColumnIndexOrThrow(_cursor, "images");
      final List<WeatherListItem> _result = new ArrayList<WeatherListItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final WeatherListItem _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
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
        final List<WeatherItem> _tmpWeatherItems;
        final String _tmp_4;
        if (_cursor.isNull(_cursorIndexOfWeatherItems)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getString(_cursorIndexOfWeatherItems);
        }
        _tmpWeatherItems = __converters.toWeatherItem(_tmp_4);
        final boolean _tmpIsSaved;
        final int _tmp_5;
        _tmp_5 = _cursor.getInt(_cursorIndexOfIsSaved);
        _tmpIsSaved = _tmp_5 != 0;
        final boolean _tmpIsCurrentLocation;
        final int _tmp_6;
        _tmp_6 = _cursor.getInt(_cursorIndexOfIsCurrentLocation);
        _tmpIsCurrentLocation = _tmp_6 != 0;
        final boolean _tmpIsMetric;
        final int _tmp_7;
        _tmp_7 = _cursor.getInt(_cursorIndexOfIsMetric);
        _tmpIsMetric = _tmp_7 != 0;
        final List<ForecastListItem> _tmpForecastList;
        final String _tmp_8;
        if (_cursor.isNull(_cursorIndexOfForecastList)) {
          _tmp_8 = null;
        } else {
          _tmp_8 = _cursor.getString(_cursorIndexOfForecastList);
        }
        _tmpForecastList = __converters.toForecastList(_tmp_8);
        final List<String> _tmpImages;
        final String _tmp_9;
        if (_cursor.isNull(_cursorIndexOfImages)) {
          _tmp_9 = null;
        } else {
          _tmp_9 = _cursor.getString(_cursorIndexOfImages);
        }
        _tmpImages = __converters.toImages(_tmp_9);
        _item = new WeatherListItem(_tmpId,_tmpName,_tmpMain,_tmpWind,_tmpSys,_tmpRain,_tmpSnow,_tmpWeatherItems,_tmpIsSaved,_tmpIsCurrentLocation,_tmpIsMetric,_tmpForecastList,_tmpImages);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
