package chkksjpt.colomind.chkksjpt.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import chkksjpt.colomind.chkksjpt.R;

/**
 * Created by Administrator on 2017/9/26.
 */

public class MapListAdapter extends RecyclerView.Adapter<MapListAdapter.MapListViewHolder> {
    public static final String[] mapNameLists = new String[]{
            "草海保护区影像图",
            "草海保护区地形图",
            "草海保护区交通图",
            "草海保护区植被分布图",
            "草海保护区调查路径图",
            "草海保护区水系图",
    };

    private MapItemClickListener mListener;
    private boolean isImageShow;
    private float textSize;

    public MapListAdapter(MapItemClickListener listener, boolean imageShow, int textSize) {
        super();
        mListener = listener;
        isImageShow = imageShow;
        this.textSize = textSize;
    }

    @Override
    public MapListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.map_list_item, parent, false);
        return new MapListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MapListViewHolder holder, int position) {
        holder.mapName.setText(mapNameLists[position]);
        /*holder.mapName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(holder.getAdapterPosition());
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mapNameLists.length;
    }

    public class MapListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mapName;
        ImageView mapIcon;
        TextView itemSymbol;

        private MapListViewHolder(View itemView) {
            super(itemView);
            mapName = itemView.findViewById(R.id.item_map_name);
            mapName.setOnClickListener(this);
            mapName.setTextSize(textSize);
            mapIcon = itemView.findViewById(R.id.item_map_icon);
            itemSymbol = itemView.findViewById(R.id.item_symbol);
            if (!isImageShow) {
                mapIcon.setVisibility(View.GONE);
                itemSymbol.setVisibility(View.GONE);
            }
        }

        @Override
        public void onClick(View view) {
            mListener.onItemClick(getAdapterPosition(), mapName.getText().toString());
        }
    }

    public interface MapItemClickListener {
        void onItemClick(int index, String itemText);
    }
}
