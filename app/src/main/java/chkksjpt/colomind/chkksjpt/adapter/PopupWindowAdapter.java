package chkksjpt.colomind.chkksjpt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.esri.core.map.FeatureTemplate;
import com.esri.core.map.FeatureType;

import java.util.ArrayList;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.drawutil.FeatureTypeData;

/**
 * Created by Administrator on 2018/1/4.
 */

public class PopupWindowAdapter extends RecyclerView.Adapter<PopupWindowAdapter.PopupViewHolder> {
    private PopupItemClickListener mListener;
    private Boolean isImageShow;
    private String[] itemList;
    private ArrayList<FeatureTemplate> templates;
    private ArrayList<FeatureTypeData> types;

    public void setItemList(String[] itemList) {
        this.itemList = itemList;
    }

    public PopupWindowAdapter(PopupItemClickListener listener, boolean imageShow, String[] itemList) {
        super();
        mListener = listener;
        isImageShow = imageShow;
        this.itemList = itemList;
    }

    public PopupWindowAdapter(PopupItemClickListener listener, ArrayList<FeatureTypeData> types) {
        super();
        mListener = listener;
        this.types = types;
    }

    @Override
    public PopupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow_layout, parent, false);
        return new PopupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PopupViewHolder holder, int position) {
        if (itemList != null) {
            holder.itemTitle.setText(itemList[position]);
            holder.itemIcon.setImageResource(R.drawable.dtll);
        } else {
            FeatureTypeData type = types.get(position);
            holder.itemTitle.setText(type.getName());
            holder.itemIcon.setImageBitmap(type.getBitmap());
        }
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.length;
        } else {
            return types.size();
        }
    }

    public class PopupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemTitle;
        ImageView itemIcon;
        LinearLayout itemLayout;

        public PopupViewHolder(View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.popup_item_layout);
            itemTitle = itemView.findViewById(R.id.popup_title);
            itemLayout.setOnClickListener(this);
            itemIcon = itemView.findViewById(R.id.popup_icon);
            if (isImageShow != null) {
                if (!isImageShow) {
                    itemIcon.setVisibility(View.GONE);
                }
            }
        }

        @Override
        public void onClick(View view) {
            mListener.onItemClick(getAdapterPosition(), itemTitle.getText().toString());
        }
    }

    public interface PopupItemClickListener {
        void onItemClick(int index, String itemText);
    }
}
