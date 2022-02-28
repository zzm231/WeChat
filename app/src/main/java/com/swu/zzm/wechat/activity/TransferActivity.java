package com.swu.zzm.wechat.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;


import androidx.appcompat.widget.Toolbar;

import com.swu.zzm.wechat.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @创建者 zzm
 * @描述 转账
 */
public class TransferActivity extends BaseActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.etMoney)
    EditText mEtMoney;

    @Override
    public void initView() {
        setContentView(R.layout.activity_transfer);
        ButterKnife.inject(this);
        initToolbar();
    }

    @Override
    public void initListener() {
        mEtMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 12) {
                    mEtMoney.setText(s.subSequence(0, 12));
                    mEtMoney.setSelection(12);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("转账");
        getSupportActionBar().setSubtitle("微信安全支付");
        mToolbar.setNavigationIcon(R.mipmap.ic_back);
    }

}
