package chkksjpt.colomind.chkksjpt.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * 这个类用于创建地图列表数据库
 * Created by Administrator on 2017/11/7.
 */

public class MapListHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "map_list.db";
    public static final String TABLE_NAME = "map_list";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_URL = "url";

    private final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + "(map" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_URL + " TEXT NOT NULL" + ")";

    public MapListHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
