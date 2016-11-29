package win.haotinayi.fakesms.strategy;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Telephony;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import win.haotinayi.fakesms.R;

/**
 * @author HaoTianYi hao.ty@haotianyi.win
 * @version v1.0
 * @des 版本大于4.4的策略
 * @time 2016-11-29 19:14
 */

public class HighStrategy extends BaseStrtegy {

    private Context mContext;
    private Button mButton;
    private String systemSms;

    public HighStrategy(Context context, Button button) {
        mContext = context;
        mButton = button;
    }

    @Override
    public BaseStrtegy setButtonStatus(Button button) {
        button.setBackgroundResource(R.drawable.btn_bg);
        button.setText("还原默认短信程序");
        return this;
    }

    @Override
    public BaseStrtegy setHintStatus(TextView textView) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public BaseStrtegy editSharedPreference(SharedPreferences index) {

        systemSms = getSystemDefaultSms();
        int count = index.getInt("count", 0);

        if (count == 0) {
            onclickSetSms(index);
            index.edit().putString("sms", systemSms);
        } else if (mContext.getPackageName().equals(Telephony.Sms.getDefaultSmsPackage(mContext))) {
            setButtonStatus(mButton);
        }

        return this;
    }

    public void onclickSetSms(SharedPreferences index) {
        if (!getSystemDefaultSms().equals(mContext.getPackageName())) {
            setDefaultSms(mContext.getPackageName());
            mButton.setBackgroundResource(R.drawable.btn_bg);
            mButton.setText("还原默认短信程序");
        } else {
            setDefaultSms(index.getString("sms", "com.android.messaging"));
            mButton.setBackgroundResource(R.drawable.btn_error);
            mButton.setText("设置成默认短信程序");
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public String getSystemDefaultSms() {
        return Telephony.Sms.getDefaultSmsPackage(mContext);
    }

    /**
     * 设置默认的短信
     *
     * @param packageName
     */
    public void setDefaultSms(String packageName) {
        Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
        intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, packageName);
        mContext.startActivity(intent);
    }
}
