package chkksjpt.colomind.chkksjpt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import chkksjpt.colomind.chkksjpt.fragment.PagerAdapter;
import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.image.CameraHelper;

/**
 * Created by Administrator on 2017/12/6.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemListViewHolder> {
    private ListItemClickListener mListener;
    private String[] itemNameList = new String[]{
            "植物资源", "动物资源", "数据采集", "监测监控"
    };
    private int itemIcon;
    private int mAdapterType;
    private int mOrientation;
    private int[] itemIconList = new int[]{R.drawable.dwzy, R.drawable.zwzy, R.drawable.tysj, R.drawable.jccy};

    public ListAdapter(ListItemClickListener listener, int orientation, int adapterType) {
        super();
        mListener = listener;
        mOrientation = orientation;
        mAdapterType = adapterType;
    }

    public void setList(String[] itemNameList, int itemIcon) {
        this.itemNameList = itemNameList;
        this.itemIcon = itemIcon;
        this.notifyDataSetChanged();
    }

    @Override
    public ItemListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
        LinearLayout listLayout = view.findViewById(R.id.data_list_layout);
        listLayout.setOrientation(mOrientation);
        return new ItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListViewHolder holder, int position) {
        holder.itemName.setText(itemNameList[position]);
        if (mAdapterType == PagerAdapter.TYPE_SOURCE_LIST) {
            CameraHelper.useGlide(holder.itemIcon, itemIconList, position);
        } else {
            holder.itemIcon.setImageResource(itemIcon);
        }
    }

    @Override
    public int getItemCount() {
        return itemNameList.length;
    }

    public class ItemListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemName;
        ImageView itemIcon;
        View rootView;
        private ItemListViewHolder(View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.data_list_layout);
            itemName = itemView.findViewById(R.id.list_item_name);
            rootView.setOnClickListener(this);
            itemIcon = itemView.findViewById(R.id.list_item_icon);
        }

        @Override
        public void onClick(View view) {
            mListener.onItemClick(getAdapterPosition());
        }
    }

    public interface ListItemClickListener {
        void onItemClick(int index);
    }
}
