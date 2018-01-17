package chkksjpt.colomind.chkksjpt.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import chkksjpt.colomind.chkksjpt.R;

public class DataDetailActivity extends AppCompatActivity {


    @BindView(R.id.data_detail_icon)
    ImageView detailIcon;
    @BindView(R.id.data_detail_text)
    TextView detailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_detail);
        ButterKnife.bind(this);
        Intent intentCarryData = getIntent();
        detailText.setText(intentCarryData.getStringExtra(getString(R.string.key_save_detail_text)));
        detailIcon.setImageResource(intentCarryData.getIntExtra(getString(R.string.key_save_photo_paths), 0));
    }
}
