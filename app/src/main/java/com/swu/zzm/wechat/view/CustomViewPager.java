package com.swu.zzm.wechat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * @author zzm
 * @描述 自定义ViewPager：首尾页面父控件拦截事件
 */
public class CustomViewPager extends ViewPager {

    private int startX;
    private int startY;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomViewPager(Context context) {
        super(context);
    }

    /**
     * 事件分发，请求父控件及祖宗控件是否拦截事件
     * 1、右划，而且是第一个页面，需要父控件拦截
     * 2、左划，而且是最后一个页面，需要父控件拦截
     * 3、上下滑动，需要父控件拦截
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //不要拦截，这样是为了保证ACTION_MOVE调用
                getParent().requestDisallowInterceptTouchEvent(true);

                startX = (int) ev.getRawX();
                startY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:

                int endX = (int) ev.getRawX();
                int endY = (int) ev.getRawY();

                //左右滑动
                if (Math.abs(endX - startX) > Math.abs(endY - startY)) {
                    //往右滑动
                    if (endX > startX) {
                        //第一个页面，需要父控件拦截
                        if (getCurrentItem() == 0) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    } else {//左划
                        //最后一个页面，需要拦截
                        if (getCurrentItem() == getAdapter().getCount() - 1) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                } else {//上下滑动
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

                break;

            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

}
