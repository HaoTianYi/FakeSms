package win.haotinayi.fakesms;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import win.haotinayi.fakesms.view.CircleImageView;

public class DetailActivity extends AppCompatActivity{

    @BindView(R.id.activity_detail)
    FrameLayout mActivityDetail;
    @BindView(R.id.cv_desc)
    CardView mCvDesc;
    @BindView(R.id.iv_circle)
    CircleImageView mIvCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        initToolBar();

    }

    public void net(View view) {
        switch (view.getId()) {
            case R.id.tv_github:
                Uri uri = Uri.parse("https://github.com/HaoTianYi/");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
                break;
            case R.id.tv_cadn:
                Uri uri1 = Uri.parse("http://blog.csdn.net/simaxiaochen/");
                Intent it1 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(it1);
                break;
            case R.id.tv_juejin:
                Uri uri2 = Uri.parse("http://gold.xitu.io/user/5821a7c2d20309005514b249/");
                Intent it2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(it2);
                break;
            case R.id.tv_zhuye:
                Uri uri3 = Uri.parse("http://www.haotianyi.win/");
                Intent it3 = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(it3);
                break;

        }
    }

    private ActionBar mSupportActionBar;

    /**
     * 给Activity设置返回
     */
    private void initToolBar() {
        mSupportActionBar = getSupportActionBar();
        mSupportActionBar.setTitle("个人信息介绍");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }





}
