package chkksjpt.colomind.chkksjpt.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.ui.DataSourceActivity;
import chkksjpt.colomind.chkksjpt.ui.ExpeditionActivity;
import chkksjpt.colomind.chkksjpt.ui.MapListActivity;

import static chkksjpt.colomind.chkksjpt.ui.DataSourceActivity.KEY_SAVE_TAG;

/**
 * Created by Administrator on 2017/12/6.
 */
public class PageChooseFragment extends Fragment {
    private Bundle args;
    private boolean isDataSource = false;
    private Intent intent = new Intent();
    @BindViews({R.id.choose_button1, R.id.choose_button2})
    List<Button> views;

    @OnClick({R.id.choose_button1, R.id.choose_button2})
    public void onButtonClick(View view) {
        /*String tag = args.getString(getString(R.string.key_fragment_tag));*/
        switch (view.getId()) {
            case R.id.choose_button1:
                if (!isDataSource) {
                    intent.setClass(this.getActivity(), ExpeditionActivity.class);
                } else {
                    intent.setClass(this.getActivity(), MapListActivity.class);
                }
                startActivity(intent);
                break;
            case R.id.choose_button2:
                if (!isDataSource) {
                    intent.putExtra(getString(R.string.key_is_data_source), true);
                    intent.setClass(this.getActivity(), DataSourceActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    public PageChooseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_choose_page, container, false);
        ButterKnife.bind(this, rootView);
        if (savedInstanceState == null) {
            args = getArguments();
            if (args != null) {
                isDataSource = args.getBoolean(KEY_SAVE_TAG, false);
            }
        }
        if (isDataSource) {
            views.get(0).setText("科考地图浏览");
            views.get(1).setText("资源数据浏览");
        }
        return rootView;
    }
}
