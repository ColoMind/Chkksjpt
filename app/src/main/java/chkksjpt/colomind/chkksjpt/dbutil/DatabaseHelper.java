package chkksjpt.colomind.chkksjpt.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import chkksjpt.colomind.chkksjpt.entity.PZYDEntity;
import chkksjpt.colomind.chkksjpt.entity.SBYDEntity;
import chkksjpt.colomind.chkksjpt.entity.WPURLEntity;
import chkksjpt.colomind.chkksjpt.entity.WPZFEntity;
import chkksjpt.colomind.chkksjpt.entity.XCPZPhotosEntity;
import chkksjpt.colomind.chkksjpt.entity.XCRWEntity;
import chkksjpt.colomind.chkksjpt.entity.XCRYEntity;
import chkksjpt.colomind.chkksjpt.entity.XCSBEntity;
import chkksjpt.colomind.chkksjpt.entity.YDXC.WFDEntity;
import chkksjpt.colomind.chkksjpt.entity.YDXC.WFDXCEntity;
import chkksjpt.colomind.chkksjpt.entity.YDXC.WFDXCRWEntity;
import chkksjpt.colomind.chkksjpt.entity.YDXC.WPZFXXTBEntity;
import chkksjpt.colomind.chkksjpt.entity.YDXC.WPZFwbhEntity;
import chkksjpt.colomind.chkksjpt.entity.ZMXX.SZHEntity;
import chkksjpt.colomind.chkksjpt.entity.ZMXX.ZMCYEntity;
import chkksjpt.colomind.chkksjpt.entity.video.Mp4Info;
import chkksjpt.colomind.chkksjpt.entity.video.VideoEntity;
import chkksjpt.colomind.chkksjpt.utils.ConstantVar;
import chkksjpt.colomind.chkksjpt.entity.CBYDEntity;
import chkksjpt.colomind.chkksjpt.entity.DZZHEntity;
import chkksjpt.colomind.chkksjpt.entity.DZZHinfoEntity;
import chkksjpt.colomind.chkksjpt.entity.GYYD.GYYDEntity;
import chkksjpt.colomind.chkksjpt.entity.JCYD.JCYDEntity;
import chkksjpt.colomind.chkksjpt.entity.KCZYEntity;
import chkksjpt.colomind.chkksjpt.entity.PHOTOSEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private  final static int version=13;

	private static final String DATABASE_NAME = "dzzh.db";
	private static final String TAG=DatabaseHelper.class.getName();

	private static final AtomicInteger usageCounter = new AtomicInteger(0);

	private static DatabaseHelper helper = null;

	private SQLiteDatabase mDefaultWritableDatabase = null;

	private DatabaseHelper(Context context) {
		super(context, ConstantVar.DATABASE_PATH+"/"+DATABASE_NAME, null, version);
//		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public static synchronized DatabaseHelper getHelper(Context context) {
		if (helper == null) {
			helper = new DatabaseHelper(context.getApplicationContext());
		}
		usageCounter.incrementAndGet();
		return helper;
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
//            this.mDefaultWritableDatabase=db;
			TableUtils.createTable(connectionSource, DZZHEntity.class);
			TableUtils.createTable(connectionSource, DZZHinfoEntity.class);
			TableUtils.createTable(connectionSource, PHOTOSEntity.class);
			TableUtils.createTable(connectionSource, XCPZPhotosEntity.class);
			TableUtils.createTable(connectionSource, XCRYEntity.class);
			TableUtils.createTable(connectionSource, WFDXCRWEntity.class);
			TableUtils.createTable(connectionSource, KCZYEntity.class);
			TableUtils.createTable(connectionSource, WPZFwbhEntity.class);
			TableUtils.createTable(connectionSource, CBYDEntity.class);
			TableUtils.createTable(connectionSource, GYYDEntity.class);
			TableUtils.createTable(connectionSource, PZYDEntity.class);
			TableUtils.createTable(connectionSource, SBYDEntity.class);
			TableUtils.createTable(connectionSource, JCYDEntity.class);
			TableUtils.createTable(connectionSource, WPURLEntity.class);
			TableUtils.createTable(connectionSource, WPZFEntity.class);
			TableUtils.createTable(connectionSource, XCRWEntity.class);
			TableUtils.createTable(connectionSource, WFDEntity.class);
			TableUtils.createTable(connectionSource, WFDXCEntity.class);
			TableUtils.createTable(connectionSource, WPZFXXTBEntity.class);
			TableUtils.createTable(connectionSource, Mp4Info.class);
			TableUtils.createTable(connectionSource, VideoEntity.class);
			TableUtils.createTable(connectionSource, ZMCYEntity.class);
			TableUtils.createTable(connectionSource, SZHEntity.class);

			Log.i(TAG, "created new entries in onCreate: ");
		} catch (SQLException e) {
			Log.e(TAG, "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public ConnectionSource getConnectionSource() {
		return super.getConnectionSource();
	}


	@Override
	public boolean isOpen() {
		return super.isOpen();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(TAG, "onUpgrade");
			this.mDefaultWritableDatabase=db;
			TableUtils.dropTable(connectionSource, DZZHEntity.class, true);
			TableUtils.dropTable(connectionSource, DZZHinfoEntity.class, true);
			TableUtils.dropTable(connectionSource,PHOTOSEntity.class,true);
			TableUtils.dropTable(connectionSource, XCPZPhotosEntity.class, true);
			TableUtils.dropTable(connectionSource, XCRYEntity.class,true);
			TableUtils.dropTable(connectionSource, WFDXCRWEntity.class, true);
			TableUtils.dropTable(connectionSource, KCZYEntity.class, true);
			TableUtils.dropTable(connectionSource, WPZFwbhEntity.class, true);
			TableUtils.dropTable(connectionSource, CBYDEntity.class, true);
			TableUtils.dropTable(connectionSource, GYYDEntity.class, true);
			TableUtils.dropTable(connectionSource, PZYDEntity.class, true);
			TableUtils.dropTable(connectionSource, SBYDEntity.class, true);
			TableUtils.dropTable(connectionSource, JCYDEntity.class, true);
			TableUtils.dropTable(connectionSource, WPURLEntity.class, true);
			TableUtils.dropTable(connectionSource, WPZFEntity.class, true);
			TableUtils.dropTable(connectionSource, XCRWEntity.class, true);
			TableUtils.dropTable(connectionSource, XCSBEntity.class, true);
			TableUtils.dropTable(connectionSource, WFDEntity.class, true);
			TableUtils.dropTable(connectionSource, WFDXCEntity.class, true);
			TableUtils.dropTable(connectionSource, WPZFXXTBEntity.class, true);
			TableUtils.dropTable(connectionSource, Mp4Info.class, true);
			TableUtils.dropTable(connectionSource, VideoEntity.class, true);
			TableUtils.dropTable(connectionSource, ZMCYEntity.class, true);
			TableUtils.dropTable(connectionSource, SZHEntity.class, true);

			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(TAG, "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

    @Override
    public SQLiteDatabase getWritableDatabase() {
        final SQLiteDatabase db;
        if(mDefaultWritableDatabase != null){
            db = mDefaultWritableDatabase;
        } else {
            db = super.getWritableDatabase();
        }
        return db;
    }

    @Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		try {
			Log.i(TAG, "onDowngrade");
			this.mDefaultWritableDatabase=db;
			TableUtils.dropTable(connectionSource, DZZHEntity.class, true);
			TableUtils.dropTable(connectionSource, DZZHinfoEntity.class, true);
			TableUtils.dropTable(connectionSource,PHOTOSEntity.class,true);
			TableUtils.dropTable(connectionSource,XCPZPhotosEntity.class,true);
			TableUtils.dropTable(connectionSource, XCRYEntity.class,true);
			TableUtils.dropTable(connectionSource, WFDXCRWEntity.class,true);
			TableUtils.dropTable(connectionSource, KCZYEntity.class, true);
			TableUtils.dropTable(connectionSource, WPZFwbhEntity.class, true);
			TableUtils.dropTable(connectionSource, CBYDEntity.class, true);
			TableUtils.dropTable(connectionSource, GYYDEntity.class, true);
			TableUtils.dropTable(connectionSource, PZYDEntity.class, true);
			TableUtils.dropTable(connectionSource, SBYDEntity.class, true);
			TableUtils.dropTable(connectionSource, JCYDEntity.class, true);
			TableUtils.dropTable(connectionSource, WPURLEntity.class, true);
			TableUtils.dropTable(connectionSource, WPZFEntity.class, true);
			TableUtils.dropTable(connectionSource, XCRWEntity.class, true);
			TableUtils.dropTable(connectionSource, XCSBEntity.class, true);
			TableUtils.dropTable(connectionSource, WFDEntity.class, true);
			TableUtils.dropTable(connectionSource, WFDXCEntity.class, true);
			TableUtils.dropTable(connectionSource, WPZFXXTBEntity.class, true);
			TableUtils.dropTable(connectionSource, Mp4Info.class, true);
			TableUtils.dropTable(connectionSource, VideoEntity.class, true);
			TableUtils.dropTable(connectionSource, ZMCYEntity.class, true);
			TableUtils.dropTable(connectionSource, SZHEntity.class, true);
			onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(TAG, "Can't drop databases", e);
			throw new RuntimeException(e);
		}

	}

	@Override
	public void close() {
		if (usageCounter.decrementAndGet() == 0) {
			super.close();
			helper = null;
		}
	}
}