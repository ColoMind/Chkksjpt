package chkksjpt.colomind.chkksjpt.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import chkksjpt.colomind.chkksjpt.R;

/**
 * Created by Administrator on 2017/12/7.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private int mCount;
    public static final int TYPE_SOURCE_LIST = 0;
    public static final int TYPE_DATA_LIST = 1;
    private int mAdapterType;
    private Fragment pagerFragment;

    public PagerAdapter(FragmentManager fm, Context context, int itemCount, int type) {
        super(fm);
        mContext = context;
        mCount = itemCount;
        mAdapterType = type;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        String[] titles;
        if (mAdapterType == TYPE_SOURCE_LIST) {
            titles = mContext.getResources().getStringArray(R.array.resource_title);
        } else {
            titles = mContext.getResources().getStringArray(R.array.data_list_title);
        }
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {
        /*Bundle bundle = new Bundle();*/
        if (position == 0) {
            if (mAdapterType == TYPE_SOURCE_LIST) {
                pagerFragment = new MapListFragment();
            } else {
                //TODO replace pagerFragment in the right Fragment;
                pagerFragment = new DataListFragment();
            }
        } else {
            if (mAdapterType == TYPE_SOURCE_LIST) {
                pagerFragment = new ResourceListFragment();
            } else {
                //TODO replace pagerFragment in the right Fragment;
                pagerFragment = new DataListFragment();
            }
        }

        Bundle bundle = new Bundle();
        bundle.putInt(mContext.getString(R.string.key_save_adapter_num), position);
        bundle.putInt(mContext.getString(R.string.key_save_adapter_type), mAdapterType);
        pagerFragment.setArguments(bundle);
        return pagerFragment;
    }

    @Override
    public int getCount() {
        return mCount;
    }
}
