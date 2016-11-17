package win.haotinayi.fakesms;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * @author HaoTianYi hao.ty@haotianyi.win
 * @version v1.0
 * @des
 * @time 2016-11-15 19:32
 */

public class SmsWatcher implements TextWatcher {

    private TextChangingListener mChangingListener;

    public SmsWatcher(TextChangingListener changingListener) {
        mChangingListener = changingListener;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        mChangingListener.onChange(s);
    }

    public interface TextChangingListener {
        void onChange(Editable s);
    }
}
