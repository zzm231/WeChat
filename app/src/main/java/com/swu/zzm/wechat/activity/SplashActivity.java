package com.swu.zzm.wechat.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import com.swu.zzm.wechat.R;
import com.swu.zzm.wechat.nimsdk.utils.NimAccountSDK;
import com.swu.zzm.wechat.utils.UIUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zzm
 * @描述 欢迎界面
 */
public class SplashActivity extends BaseActivity {


    @OnClick(R.id.btnLogin)
    public void login() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @OnClick(R.id.btnRegister)
    public void register() {
        UIUtils.showToast("暂不支持");
//        startActivity(new Intent(this, RegisterActivity.class));
//        finish();
    }

    @Override
    public void init() {
        if (canAutoLogin()) {
            //登录到主界面
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);
    }

    /**
     * 判断是否可以自动登录
     *
     * @return
     */
    public boolean canAutoLogin() {
        String account = NimAccountSDK.getUserAccount();
        String token = NimAccountSDK.getUserAccount();
        return !TextUtils.isEmpty(account) && !TextUtils.isEmpty(token);
    }

}
