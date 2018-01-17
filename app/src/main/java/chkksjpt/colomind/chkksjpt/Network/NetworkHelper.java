package chkksjpt.colomind.chkksjpt.Network;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import chkksjpt.colomind.chkksjpt.BaseApplication;
import chkksjpt.colomind.chkksjpt.data.MapListHelper;
import chkksjpt.colomind.chkksjpt.utils.ToastUtil;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static chkksjpt.colomind.chkksjpt.data.MapListHelper.COLUMN_NAME;
import static chkksjpt.colomind.chkksjpt.data.MapListHelper.COLUMN_URL;

/**
 * 使用Retrofit2 发起网络请求
 * Created by Administrator on 2017/9/29.
 */

public class NetworkHelper {
    private ArrayList<String> mapUrlList = new ArrayList<>();
    private ArrayList<String> mapNameList = new ArrayList<>();
    public static final String UPLOAD_BASE_URL = "http://192.168.2.111:1112/service/vedios/GetVedios.asmx/";

    private static Retrofit createRxjavaRetrofit(String baseUrl, int timeOut) {
        OkHttpClient client = new OkHttpClient();
        client.newBuilder().connectTimeout(timeOut, TimeUnit.SECONDS);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static Observable<RequestBody> uploadPhotos(String postUrl, List<MultipartBody.Part> partList) {
        //Retrofit 默认的超时为10秒
        NetworkService service = createRxjavaRetrofit(UPLOAD_BASE_URL, 4).create(NetworkService.class);
        return service.uploadPhotos(postUrl, partList);
    }

    public static Call<File> downloadFile(String downloadUrl) {
        NetworkService service = createRxjavaRetrofit(null, 10).create(NetworkService.class);
        return service.downloadFile(downloadUrl);
    }

    public static Observable<ResponseBody> uploadFiles(String methodName, List<MultipartBody.Part> partList) {
        NetworkService service = createRxjavaRetrofit(UPLOAD_BASE_URL, 10).create(NetworkService.class);
        return service.uploadFiles(methodName, partList);
    }

    //获取包含地图列表的数据库
    public void getMapList(final Context context) {
        MapListHelper mHelper = new MapListHelper(context);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        Cursor cursor = db.query(MapListHelper.TABLE_NAME, null, null, null, null, null, null);
        if (cursor == null) {
            //TODO Add True downloadUrl
            Call<File> callDB = NetworkHelper.downloadFile("needs url here");
            callDB.enqueue(new Callback<File>() {
                @Override
                public void onResponse(Call<File> call, Response<File> response) {
                    ToastUtil.show(context, "下载地图数据库成功");
                }

                @Override
                public void onFailure(Call<File> call, Throwable t) {
                    ToastUtil.show(context, "下载地图数据库失败");
                }
            });
        }
        cursor = db.query(MapListHelper.TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            mapUrlList.add(cursor.getString(cursor.getColumnIndex(COLUMN_URL)));
            mapNameList.add(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)));
        }
        BaseApplication.getInstance().mapNameList = mapNameList;
        BaseApplication.getInstance().mapUrlList = mapUrlList;
        cursor.close();
    }

}
