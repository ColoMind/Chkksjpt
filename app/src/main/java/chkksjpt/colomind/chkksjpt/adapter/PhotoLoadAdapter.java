package chkksjpt.colomind.chkksjpt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.image.CameraHelper;

/**
 * Created by Administrator on 2017/9/22.
 * Recyclerview 用来显示照片的适配器
 */

public class PhotoLoadAdapter extends RecyclerView.Adapter<PhotoLoadAdapter.PhotoViewHolder> {
    private ArrayList<String> photoPaths = new ArrayList<>();
    final private photoItemClickListener mListener;

    public PhotoLoadAdapter(photoItemClickListener listener) {
        mListener = listener;
    }

    public void setPaths(ArrayList<String> paths) {
        photoPaths = paths;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, int position) {
        CameraHelper.useGlide(holder.imageView,photoPaths,position);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onPhotoClick(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoPaths.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.preview_photo);
        }

        @Override
        public void onClick(View view) {
            mListener.onPhotoClick(getAdapterPosition());
        }
    }

    public interface photoItemClickListener {
        void onPhotoClick(int index);
    }
}
