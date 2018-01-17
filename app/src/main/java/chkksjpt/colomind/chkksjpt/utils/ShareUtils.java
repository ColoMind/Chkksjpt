package chkksjpt.colomind.chkksjpt.utils;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/9/5 0005.
 * SharedPreference封装，其本质是形成一个名字叫“”config.xml的文件存放于系统中，该文件中存放很多键值对
 */

public class ShareUtils {
    public static  final String NAME="config";//xml文件名
    //键 值
    public static void putString(Context mContext, String key, String value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();

    }
    public static String getString(Context mContext, String key, String defValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }
    public static void putInt(Context mContext, String key, int value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();

    }
    public static int getInt(Context mContext, String key, int defValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }
    public static void putBoolean(Context mContext, String key, boolean value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();

    }
    public static boolean getBoolean(Context mContext, String key, boolean defValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }

    public  static  void deleShare(Context mContext, String key){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }
    public static void deleAll(Context mContext){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }

}
