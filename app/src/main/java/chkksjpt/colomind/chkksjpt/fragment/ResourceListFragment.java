package chkksjpt.colomind.chkksjpt.fragment;

import android.content.Intent;
import android.os.Bundle;
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
import chkksjpt.colomind.chkksjpt.ui.DataListActivity;

public class ResourceListFragment extends Fragment {
    @BindViews({R.id.button_animal, R.id.button_plant, R.id.button_comprehensive})
    List<Button> buttons;

    @OnClick({R.id.button_animal, R.id.button_plant, R.id.button_comprehensive})
    public void onButtonClick(View view) {
        Intent intent = new Intent(this.getActivity(), DataListActivity.class);
        startActivity(intent);
        switch (view.getId()) {
            case R.id.button_animal:
                break;
            case R.id.button_plant:
                break;
            case R.id.button_comprehensive:
                break;
        }
    }

    public ResourceListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_source_list, container, false);
        ButterKnife.bind(this, view);
        String[] array = view.getResources().getStringArray(R.array.data_list_title);
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText(array[i]);
        }
        return view;
    }
}
