package chkksjpt.colomind.chkksjpt.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.adapter.MapListAdapter;
import chkksjpt.colomind.chkksjpt.utils.ConstantVar;

public class MapListActivity extends AppCompatActivity {

    private String[] mapUrlLists = new String[]{
            ConstantVar.DZZHMAPURL,
            ConstantVar.XZQHMAPURL,
            ConstantVar.TDLYXZURL,
            ConstantVar.TDGHURL,
            ConstantVar.TDJBNTURL,
            ConstantVar.BPDKTURL,
            ConstantVar.CSGHTURL,
            ConstantVar.KCFBTURL,
            ConstantVar.IMAGEURL
    };

    public static ArrayList<String> mapUrlList = new ArrayList<>();
    public static ArrayList<String> mapNameList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);
        initView();
    }

    public void initView() {
        RecyclerView mapListView = findViewById(R.id.map_list_pre);
        mapListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mapListView.setHasFixedSize(true);
        MapListAdapter mAdapter = new MapListAdapter(new MapListAdapter.MapItemClickListener() {
            @Override
            public void onItemClick(int index, String itemText) {
                Intent intent = new Intent(MapListActivity.this, MapChangeActivity.class);
                intent.putExtra(getString(R.string.key_save_map_url), mapUrlLists[index]);
                intent.putExtra(getString(R.string.key_save_map_name), itemText);
                startActivity(intent);
            }
        }, true, 24);
        mapListView.setAdapter(mAdapter);
    }
}
