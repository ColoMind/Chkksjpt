package chkksjpt.colomind.chkksjpt.ui;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import chkksjpt.colomind.chkksjpt.fragment.PageChooseFragment;
import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.runtimePermissions.PermissionsManager;
import chkksjpt.colomind.chkksjpt.runtimePermissions.PermissionsResultAction;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();
        PageChooseFragment chooseFrag = new PageChooseFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, chooseFrag).commit();
    }

    @TargetApi(23)
    private void requestPermissions() {
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
				//Toast.makeText(MainActivity.this, "All permissions have been granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDenied(String permission) {
                //Toast.makeText(MainActivity.this, "Permission " + permission + " has been denied", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
