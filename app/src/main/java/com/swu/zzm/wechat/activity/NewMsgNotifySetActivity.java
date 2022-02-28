package com.swu.zzm.wechat.activity;

import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.swu.zzm.wechat.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @创建者 zzm
 * @描述 新消息提醒
 */
public class NewMsgNotifySetActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public void initView() {
        setContentView(R.layout.activity_new_msg_notify_set);
        ButterKnife.inject(this);
        initToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("新消息提醒");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.mipmap.ic_back);
    }
}
