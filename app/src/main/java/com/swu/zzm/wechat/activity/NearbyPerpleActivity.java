package com.swu.zzm.wechat.activity;

import android.view.MenuItem;
import android.view.View;


import androidx.appcompat.widget.Toolbar;

import com.swu.zzm.wechat.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @创建者 CSDN_LQR
 * @描述 附近的人
 */

public class NearbyPerpleActivity extends BaseActivity {
    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    public void initView() {
        setContentView(R.layout.activity_nearby_perple);
        ButterKnife.inject(this);
        initToolbar();
        showMaterialDialog("提示", "查看附近的人功能将获取你的位置信息，你的位置信息会被保留一段时间。通过列表右上角的清除功能可随时手动清除位置信息。", "确定", "取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideMaterialDialog();
            }
        }, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideMaterialDialog();
            }
        });
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
        getSupportActionBar().setTitle("附近的人");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationIcon(R.mipmap.ic_back);
    }
}
