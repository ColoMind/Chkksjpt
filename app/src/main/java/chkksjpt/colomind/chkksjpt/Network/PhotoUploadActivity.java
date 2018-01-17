package chkksjpt.colomind.chkksjpt.Network;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.adapter.PhotoUploadAdapter;
import chkksjpt.colomind.chkksjpt.utils.ToastUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class PhotoUploadActivity extends AppCompatActivity {
    public static final String TOKEN = "token";
    PhotoUploadAdapter mAdapter;
    RecyclerView photoUploadList;
    boolean havePhotoRemained = false;
    ArrayList<String> photoRemained = new ArrayList<>();
    public static final int LIMITEDSIZE = 1024;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_upload);
        photoUploadList = findViewById(R.id.photo_remain_view);
        ArrayList<String> photoPaths = getIntent().getStringArrayListExtra(getString(R.string.key_save_photo_paths));
        mAdapter = new PhotoUploadAdapter(photoPaths, this);
        photoUploadList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        photoUploadList.setAdapter(mAdapter);
        photoUploadList.setHasFixedSize(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_upload_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.upload_multi_photo) {
            //TODO upLoadImages Here
            upLoadImages();
        }
        return super.onOptionsItemSelected(item);
    }

    /*public void setModeMulti() {
        for (int i = 0; i < mAdapter.getItemCount(); i++) {
            PhotoUploadAdapter.PhotoMessageViewHolder holder
                    = (PhotoUploadAdapter.PhotoMessageViewHolder) photoUploadList.getChildViewHolder(photoUploadList.getChildAt(i));

            //此处需要让所有的布局都更改，但由于RecyclerView循环利用了holder,导致第5个后的holder为空指针
        }
    }*/

    //上传多张图片
    private void upLoadImages() {
        List<String> pathList = mAdapter.getSelectedPhotos();//获取多张待上传图片的地址列表
        if (pathList == null) {
            ToastUtil.show(this, "代传照片列表为空");
            return;
        }
        Log.i("SizeOfList", String.valueOf(pathList.size()));
        String token = "ASDDSKKK19990SDDDSS";//用户token
        MultipartBody.Builder builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)//表单类型
                .addFormDataPart(TOKEN, token);//TOKEN 自定义参数key常量类，即参数名
        //多张图片
        for (int i = 0; i < pathList.size(); i++) {
            /*File file = BitmapUtils.saveCompressImage(pathList.get(i), LIMITEDSIZE);//传入图片的地址以及限制的大小*/
            File file = new File(pathList.get(i));
            RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            builder.addFormDataPart("territorialImgFile" + i, file.getName(), fileBody);//"imgfile"+i 后台接收图片流的参数名
        }
        List<MultipartBody.Part> parts = builder.build().parts();
        NetworkHelper
                .uploadFiles("FileUploadByBase64String", parts)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    Disposable mDisposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(ResponseBody value) {
                        Log.i("UploadPhotoSuc", value.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("UploadPhotoFail", e.toString());
                        havePhotoRemained = true;
                        mDisposable.dispose();
                    }

                    @Override
                    public void onComplete() {
                        mDisposable.dispose();
                    }
                });
    }

    //若上传失败，保存照片后此方法可以显示哪些照片需要再次上传
    void displayRemained() {
        if (havePhotoRemained) mAdapter.setPhotoPaths(photoRemained);
    }
}
