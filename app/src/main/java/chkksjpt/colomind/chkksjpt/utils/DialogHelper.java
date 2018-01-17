package chkksjpt.colomind.chkksjpt.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import me.drakeet.materialdialog.MaterialDialog;

/**
 * Created by Administrator on 2017/11/29.
 */

public class DialogHelper {
    private ViewGroup mViewRoot;
    private Activity mActivity;
    private AlertDialog.Builder builder;
    private View dialogView;
    private TextView titleText;
    private MultiAutoCompleteTextView showText;
    private View.OnClickListener mNegativeListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            materialDialog.dismiss();
        }
    };
    private MaterialDialog materialDialog;

    public DialogHelper(Activity activity) {
        mActivity = activity;
        /*dialogView = LayoutInflater.from(mActivity).inflate(R.layout.simple_button_dialog, null);
        titleText = dialogView.findViewById(R.id.dialog_title);
        showText = dialogView.findViewById(R.id.dialog_message);
        builder = new AlertDialog.Builder(mActivity);*/
    }


    /*public AlertDialog buildAlertDialog(CharSequence title, CharSequence message, DialogInterface.OnClickListener positiveListener, boolean cancelable, boolean selectable) {
        titleText.setText(title);
        if (message != null) {
            showText.setText(message);
            showText.setTextIsSelectable(selectable);
        } else {
            showText.setVisibility(View.GONE);
        }
        builder.setView(dialogView)
                .setCancelable(cancelable);

        if (positiveListener != null) {
            builder.setPositiveButton("确定", positiveListener);
        }
        return builder.create();
    }*/

    public MaterialDialog buildMaterialDialog(CharSequence title, CharSequence message, boolean cancelable, View.OnClickListener positiveListener, View.OnClickListener negativeListener) {
        materialDialog = new MaterialDialog(mActivity)
                .setTitle(title)
                .setMessage(message)
                .setCanceledOnTouchOutside(cancelable);
        if (negativeListener == null) {
            materialDialog.setNegativeButton("取消", mNegativeListener);
        } else {
            materialDialog.setNegativeButton("取消", negativeListener);
        }
        if (positiveListener == null) {
            materialDialog.setPositiveButton("确定", mNegativeListener);
        } else {
            materialDialog.setPositiveButton("确定", positiveListener);
        }
        materialDialog.show();
        return materialDialog;
    }

    /*public MaterialDialog setButton() {

    }*/


    /*titleText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (android.os.Build.VERSION.SDK_INT > 11) {
                    try {
                        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText("Label", ((TextView) view).getText());
                        manager.setPrimaryClip(clipData);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });*/
}
