package com.swu.zzm.wechat.pager;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.swu.zzm.wechat.R;
import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;

/**
 * @author zzm
 * @描述 基本页面（用于替换Fragment）
 */
public abstract class BasePager {

    //缓存标记
    public String cacheTag = this.getClass().getSimpleName();

    public Activity mActivity;
    //布局对象
    public View mRootView;
    //内容
    public FrameLayout flContent;
    //空订单提示
    public RelativeLayout mRlOrderNull;
    //进度条
    public RelativeLayout mRlProgress;
    public DilatingDotsProgressBar mProgress;

    public BasePager(Activity activity) {
        mActivity = activity;
        init();
        initListener();
    }

    private void init() {
        mRootView = View.inflate(mActivity, R.layout.base_pager, null);
        flContent = (FrameLayout) mRootView.findViewById(R.id.fl_content);
        mRlOrderNull = (RelativeLayout) mRootView.findViewById(R.id.rlOrderNull);
        mRlProgress = (RelativeLayout) mRootView.findViewById(R.id.rlProgress);
        mProgress = (DilatingDotsProgressBar) mRootView.findViewById(R.id.progress);
        mProgress.showNow();
        flContent.addView(initView());
    }

    /**
     * 初始化布局
     */
    public abstract View initView();

    /**
     * 初始化数据
     */
    public void initData() {

    }

    /**
     * 初始化事件
     */
    public void initListener() {

    }


}
