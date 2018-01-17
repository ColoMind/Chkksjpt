package chkksjpt.colomind.chkksjpt.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import chkksjpt.colomind.chkksjpt.fragment.PagerAdapter;
import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.adapter.ListAdapter;

public class ExpeditionActivity extends AppCompatActivity {
    @BindView(R.id.list_view)
    RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expedition);
        ButterKnife.bind(this);
        ListAdapter mAdapter = new ListAdapter(new ListAdapter.ListItemClickListener() {
            @Override
            public void onItemClick(int index) {

            }
        }, LinearLayoutManager.VERTICAL, PagerAdapter.TYPE_SOURCE_LIST);
        listView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        listView.setHasFixedSize(true);
        listView.setAdapter(mAdapter);
    }
}
