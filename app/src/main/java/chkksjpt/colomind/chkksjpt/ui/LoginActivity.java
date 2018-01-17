package chkksjpt.colomind.chkksjpt.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import chkksjpt.colomind.chkksjpt.BaseApplication;
import chkksjpt.colomind.chkksjpt.R;
import chkksjpt.colomind.chkksjpt.utils.StaticClass;
import chkksjpt.colomind.chkksjpt.utils.UtilTools;

public class LoginActivity extends AppCompatActivity {

    final String DENG_LU = "webGetLoginUserInfo";//web端服务方法名称
    private EditText uidEditText = null;
    private EditText pwdEditText = null;
    private CheckBox saveUserInfo;
    private String Namespace = "http://tempuri.org/";
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BaseApplication.getInstance().addActivity(this);
        initTv();
        editor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance().applicationContext).edit();
        editor.apply();
        getUserInfo();
    }

    private void getUserInfo() {
        String keySaveUserName = getString(R.string.key_save_username);
        String keySaveChecked = getString(R.string.key_save_checked);
        String keySavePassword = getString(R.string.key_save_password);
        SharedPreferences LOGIN_INFO = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance().applicationContext);

        if (LOGIN_INFO.getString(keySaveUserName, null) != null && LOGIN_INFO.getString(keySavePassword, null) != null) {
            uidEditText.setText(LOGIN_INFO.getString(keySaveUserName, null));
        }
        if (LOGIN_INFO.getBoolean(keySaveChecked, false)) {
            pwdEditText.setText(LOGIN_INFO.getString(keySavePassword, null));
            saveUserInfo.setChecked(true);
        }
    }

    public void startLogin(View v) {
        String uid = uidEditText.getText().toString().trim();
        String pwd = pwdEditText.getText().toString().trim();

        if (uid.isEmpty()) {
            UtilTools.Toastshow(this, "请输入用户名!");
            uidEditText.requestFocus();
            return;
        } else if (pwd.isEmpty()) {
            UtilTools.Toastshow(this, "请输入密码!");
            pwdEditText.requestFocus();
            return;
        } else {
            Map<String, String> values = new HashMap<String, String>();
            values.put("uid", uid);
            values.put("pwd", pwd);
            Request(DENG_LU, values);
        }
    }

    public void Request(Object... params) {
        try {
            new AsyncTask<Object, Object, String>() {
                @Override
                protected String doInBackground(Object... params) {
                    if (params != null && params.length == 2) {
                        return CallWebservice((String) params[0], (Map<String, String>) params[1]);
                    } else if (params != null && params.length == 1) {
                        return CallWebservice((String) params[0], null);
                    } else {
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(String result) {
                    if (result != null) {
                        saveUserPref(saveUserInfo.isChecked());
                        GotoMain();
                    }
                }
            }.execute(params).get(300, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            UtilTools.Toastshow(LoginActivity.this, "线程执行异常");
        } catch (TimeoutException e) {
            e.printStackTrace();
            UtilTools.Toastshow(LoginActivity.this, "连接服务器超时");
            LoginActivity.this.finish();
        }
    }

    public String CallWebservice(String MethodName, Map<String, String> Params) {
        SoapObject reguest = new SoapObject(Namespace, MethodName);
        if (Params != null) {
            Iterator iter = Params.entrySet().iterator();//迭代器（Iterator）
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                reguest.addProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER12);
        envelope.bodyOut = reguest;
        envelope.dotNet = true;
        HttpTransportSE ht = new HttpTransportSE(StaticClass.LOGINURL);
        try {
            ht.call(null, envelope);
        } catch (HttpResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            final SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            if (result != null) {
                Log.d("---shoudaohuifu----", result.toString());
                return result.toString();
            }
        } catch (SoapFault e) {
            Log.e("---cuowufasheng---", e.getMessage());
        }
        return null;
    }

    private void initTv() {
        uidEditText = findViewById(R.id.username);
        pwdEditText = findViewById(R.id.password);
        saveUserInfo = findViewById(R.id.save_userinfo);
        ((TextView) findViewById(R.id.text_technology_support)).append("技术支持:贵州工程应用技术学院" + "\n" + "毕节市鹏博科技有限责任公司");
    }

    public void saveUserPref(boolean isSave) {
        String userName = uidEditText.getText().toString();
        String passWord = pwdEditText.getText().toString();
        if (isSave & !TextUtils.isEmpty(userName) & !TextUtils.isEmpty(passWord)) {
            editor.putString(getString(R.string.key_save_username), userName)
                    .putString(getString(R.string.key_save_password), passWord)
                    .putBoolean(getString(R.string.key_save_checked), true)
                    .apply();
        }
    }

    public void GotoMain() {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        saveUserPref(saveUserInfo.isChecked());
        LoginActivity.this.finish();
    }

}
