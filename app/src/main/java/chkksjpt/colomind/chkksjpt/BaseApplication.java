package chkksjpt.colomind.chkksjpt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.multidex.MultiDex;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import chkksjpt.colomind.chkksjpt.utils.StaticClass;
import chkksjpt.colomind.chkksjpt.utils.UtilTools;

/**
 * Created by zpf on 2017/9/5 0005.
 */

public class BaseApplication extends android.support.multidex.MultiDexApplication {
    public Context applicationContext;
    private static BaseApplication instance;

    //一下两个字段为绑定服务需要
    //UploadOfflineDataService receiveMsgService;
    private boolean conncetState = true; // 记录当前连接状态，因为广播会接收所有的网络状态改变wifi/3g等等，所以需要一个标志记录当前状态
    private Handler handler;
    //存储Activity
    private List<Activity> Activity_List = new ArrayList<>();
    public HashMap<String, String> mInfoMap = new HashMap<String, String>();
    public ArrayList<String> mapUrlList = new ArrayList<>();
    public ArrayList<String> mapNameList = new ArrayList<>();

    @Override
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();
        applicationContext = this;
        instance = this;
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (0 == msg.arg1) {
                    UtilTools.Toastshow(BaseApplication.this, "请检查手机存储卡");
                }
            }
        };
    }

    //添加Activity到容器中
    public void addActivity(Activity activity) {
        Activity_List.add(activity);
    }
    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
