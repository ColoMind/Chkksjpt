package chkksjpt.colomind.chkksjpt.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import chkksjpt.colomind.chkksjpt.fragment.PagerAdapter;
import chkksjpt.colomind.chkksjpt.R;

public class DataListActivity extends AppCompatActivity {
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.pager_tabs)
    TabLayout pagerTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager(), this,3,PagerAdapter.TYPE_DATA_LIST));
        pagerTab.setupWithViewPager(pager);
        
    }
}
