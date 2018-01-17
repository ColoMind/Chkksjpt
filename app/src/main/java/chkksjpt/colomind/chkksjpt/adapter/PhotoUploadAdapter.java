package chkksjpt.colomind.chkksjpt.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.image.CameraHelper;

/**
 * Created by Administrator on 2017/10/7.
 */

public class PhotoUploadAdapter extends RecyclerView.Adapter<PhotoUploadAdapter.PhotoMessageViewHolder> {
    private PhotoLoadAdapter.photoItemClickListener mClickListener;
    private ArrayList<String> selectedPhotos;
    private Activity mActivity;
    private ArrayList<String> photosToUpload = new ArrayList<>();

    public PhotoUploadAdapter(ArrayList<String> photoPaths, Activity activity) {
        super();
        selectedPhotos = photoPaths;
        mActivity = activity;
    }

    public void setPhotoPaths(ArrayList<String> paths) {
        selectedPhotos = paths;
        notifyDataSetChanged();
    }

    @Override
    public PhotoMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.photo_detail_view, parent, false);
        mClickListener = new PhotoLoadAdapter.photoItemClickListener() {
            @Override
            public void onPhotoClick(int index) {
                CameraHelper.previewPhoto(mActivity, selectedPhotos, index);
            }
        };
        return new PhotoMessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PhotoMessageViewHolder holder, int position) {
        CameraHelper.useGlide(holder.photoPreview, selectedPhotos, position);
    }

    @Override
    public int getItemCount() {
        return selectedPhotos.size();
    }

    public class PhotoMessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView photoPreview;
        TextView selecTime;
        CheckBox selecIfMulti;

        PhotoMessageViewHolder(View itemView) {
            super(itemView);
            photoPreview = itemView.findViewById(R.id.item_preview_photo);
            selecTime = itemView.findViewById(R.id.item_selec_time);
            selecIfMulti = itemView.findViewById(R.id.selec_if_multi);
            photoPreview.setOnClickListener(this);
            selecTime.setOnClickListener(this);
            selecIfMulti.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.item_preview_photo:
                    mClickListener.onPhotoClick(getAdapterPosition());
                    break;
                case R.id.item_selec_time:
                    break;
                case R.id.selec_if_multi:
                    if (selecIfMulti.isChecked()) {
                        photosToUpload.add(selectedPhotos.get(getAdapterPosition()));
                        Log.i("照片数量的改变", "位于" + getAdapterPosition() + "的照片加入了列表");
                    } else {
                        photosToUpload.remove(selectedPhotos.get(getAdapterPosition()));
                        Log.i("照片数量的改变", "位于" + getAdapterPosition() + "的照片从列表移除");
                    }
                    break;
            }
        }
    }


    public ArrayList<String> getSelectedPhotos() {
        return photosToUpload;
    }

    /*void setModeMulti() {
        isModeMulti = true;

    }*/
}
