package win.haotinayi.fakesms.strategy;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author HaoTianYi hao.ty@haotianyi.win
 * @version v1.0
 * @des  版本小于4.4的策略
 * @time 2016-11-29 19:15
 */

public class LowStrategy extends BaseStrtegy {

    @Override
    public BaseStrtegy setButtonStatus(Button button) {
        button.setVisibility(View.GONE);
        return this;
    }

    @Override
    public BaseStrtegy setHintStatus(TextView textView) {
        textView.setText("请点击插入短信");
        return this;
    }
}
