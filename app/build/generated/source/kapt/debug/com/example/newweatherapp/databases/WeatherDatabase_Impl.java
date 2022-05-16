package com.example.newweatherapp.databases;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherDatabase_Impl extends WeatherDatabase {
  private volatile WeatherDao _weatherDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `weather_table` (`name` TEXT NOT NULL, `main` TEXT NOT NULL, `wind` TEXT, `sys` TEXT NOT NULL, `rain` TEXT, `snow` REAL, `weatherItem` TEXT NOT NULL, `isAdded` INTEGER NOT NULL, PRIMARY KEY(`name`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '10513be8c922fc77091a31090d5547cd')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `weather_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
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
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWeatherTable = new HashMap<String, TableInfo.Column>(8);
        _columnsWeatherTable.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherTable.put("main", new TableInfo.Column("main", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherTable.put("wind", new TableInfo.Column("wind", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherTable.put("sys", new TableInfo.Column("sys", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherTable.put("rain", new TableInfo.Column("rain", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherTable.put("snow", new TableInfo.Column("snow", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherTable.put("weatherItem", new TableInfo.Column("weatherItem", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeatherTable.put("isAdded", new TableInfo.Column("isAdded", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWeatherTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWeatherTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWeatherTable = new TableInfo("weather_table", _columnsWeatherTable, _foreignKeysWeatherTable, _indicesWeatherTable);
        final TableInfo _existingWeatherTable = TableInfo.read(_db, "weather_table");
        if (! _infoWeatherTable.equals(_existingWeatherTable)) {
          return new RoomOpenHelper.ValidationResult(false, "weather_table(com.example.newweatherapp.models.weather.WeatherListItem).\n"
                  + " Expected:\n" + _infoWeatherTable + "\n"
                  + " Found:\n" + _existingWeatherTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "10513be8c922fc77091a31090d5547cd", "e5b43f30ec26d657daf773996efabcee");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "weather_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `weather_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WeatherDao.class, WeatherDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public WeatherDao getWeatherDao() {
    if (_weatherDao != null) {
      return _weatherDao;
    } else {
      synchronized(this) {
        if(_weatherDao == null) {
          _weatherDao = new WeatherDao_Impl(this);
        }
        return _weatherDao;
      }
    }
  }
}
