package chkksjpt.colomind.chkksjpt.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.adapter.MapListAdapter;
import chkksjpt.colomind.chkksjpt.ui.MapChangeActivity;
import chkksjpt.colomind.chkksjpt.utils.ConstantVar;


/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class MapListFragment extends Fragment {
    private String[] mapUrlLists = new String[]{
            ConstantVar.CHLIUYUURL,
            ConstantVar.CHDXTURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL,
            ConstantVar.CHGHURL
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View pager = inflater.inflate(R.layout.activity_map_list, container, false);
        initView(pager);
        return pager;
    }

    public void initView(final View rootView) {
        RecyclerView mapListView = rootView.findViewById(R.id.map_list_pre);
        mapListView.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));
        mapListView.setHasFixedSize(true);
        MapListAdapter mAdapter = new MapListAdapter(new MapListAdapter.MapItemClickListener() {
            @Override
            public void onItemClick(int index, String itemText) {
                Intent intent = new Intent(MapListFragment.this.getActivity(), MapChangeActivity.class);
                intent.putExtra(getString(R.string.key_save_map_url), mapUrlLists[index]);
                intent.putExtra(getString(R.string.key_save_map_name), itemText);
                startActivity(intent);
            }
        }, true, 18);
        mapListView.setAdapter(mAdapter);
    }

}
