package chkksjpt.colomind.chkksjpt.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.adapter.ListAdapter;
import chkksjpt.colomind.chkksjpt.ui.DataDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataListFragment extends Fragment {
    private Context mContext;
    private int itemPosition = 0;
    private int mAdapterType;
    private Bundle bundle;
    private String[] itemNameList;
    private int itemIcon;
    private ListAdapter mAdapter;

    public DataListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_data_list, container, false);
        mContext = rootView.getContext();
        initView(rootView);
        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        switch (itemPosition) {
            case 0:
                itemNameList = new String[]{
                        "水生植物",
                        "真菌",
                        "种子植物",
                        "蕨类植物",
                        "苔藓,地衣",
                        "陆生植被及生态系统",
                };
                itemIcon = R.drawable.zwzy;
                break;
            case 1:
                itemNameList = new String[]{
                        "鱼类",
                        "鸟类",
                        "浮游生物",
                        "兽类,两栖类爬行类动物",
                        "昆虫",
                        "无脊椎动物",
                };
                itemIcon = R.drawable.dwzy;
                break;
            case 2:
                itemNameList = new String[]{
                        "遗传资源",
                        "自然地理环境",
                        "水体理化性质",
                        "土壤专项",
                        "社会经济状况",
                        "生态旅游",
                        "资源利用",
                        "生态系统等级",
                };
                itemIcon = R.drawable.tysj;
                break;
        }
        mAdapter.setList(itemNameList, itemIcon);
    }

    public void initView(final View rootView) {
        RecyclerView dataListView = rootView.findViewById(R.id.data_list_view);
        dataListView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));
        dataListView.setHasFixedSize(true);
        mAdapter = new ListAdapter(new ListAdapter.ListItemClickListener() {
            @Override
            public void onItemClick(int index) {
                Intent intentStartDetail = new Intent(DataListFragment.this.getActivity(), DataDetailActivity.class);
                intentStartDetail.putExtra(getString(R.string.key_save_photo_paths), itemIcon);
                intentStartDetail.putExtra(getString(R.string.key_save_detail_text), itemNameList[index]);
                startActivity(intentStartDetail);
            }
        }, LinearLayoutManager.HORIZONTAL, PagerAdapter.TYPE_DATA_LIST);
        dataListView.setAdapter(mAdapter);
        bundle = getArguments();
        if (bundle != null) {
            itemPosition = bundle.getInt(mContext.getString(R.string.key_save_adapter_num));
            mAdapterType = bundle.getInt(mContext.getString(R.string.key_save_adapter_type));
            Log.i("itemPosition", String.valueOf(itemPosition));
        }
    }
}
