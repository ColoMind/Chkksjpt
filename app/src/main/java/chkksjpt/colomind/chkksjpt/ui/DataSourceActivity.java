package chkksjpt.colomind.chkksjpt.ui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import chkksjpt.colomind.chkksjpt.fragment.PagerAdapter;
import chkksjpt.colomind.chkksjpt.R;

public class DataSourceActivity extends AppCompatActivity {
    public static String KEY_SAVE_TAG = "save_tag";
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.pager_tabs)
    TabLayout pagerTab;

    //这里添加一个含有两个Fragment的pager
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);
        pager.setOffscreenPageLimit(2);
        PagerAdapter mAdapter = new PagerAdapter(getSupportFragmentManager(), this, 2, PagerAdapter.TYPE_SOURCE_LIST);
        pager.setAdapter(mAdapter);
        pagerTab.setupWithViewPager(pager);
    }
}
