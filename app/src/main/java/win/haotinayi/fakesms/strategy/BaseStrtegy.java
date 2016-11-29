package win.haotinayi.fakesms.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author HaoTianYi hao.ty@haotianyi.win
 * @version v1.0
 * @des
 * @time 2016-11-29 19:08
 */

public abstract class BaseStrtegy {
    /**
     * 设置权限按钮的状态
     */
    public abstract BaseStrtegy setButtonStatus(Button button);

    /**
     * 设置提示文本框的状态
     */
    public abstract BaseStrtegy setHintStatus(TextView textView);

    public BaseStrtegy editSharedPreference(SharedPreferences index) {
        return this;
    }


}
