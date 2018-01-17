package chkksjpt.colomind.chkksjpt.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

import chkksjpt.colomind.chkksjpt.R;

/**
 * Created by Administrator on 2017/12/21.
 */

public class SnackBarUtil {

    public static void createSnackBar(View snackBarLayout, String hint, View.OnClickListener listener) {
        //LENGTH_SHORT 自动消失    LENGTH_INDEFINITE 不会消失
        Snackbar snackbar = Snackbar.make(snackBarLayout, hint,
                Snackbar.LENGTH_SHORT);
        if (listener != null) {
            snackbar.setAction(R.string.ok, listener);
            snackbar.setDuration(Snackbar.LENGTH_INDEFINITE);
        }
        snackbar.show();
    }
}
