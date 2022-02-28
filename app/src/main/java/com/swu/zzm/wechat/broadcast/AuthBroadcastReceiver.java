package com.swu.zzm.wechat.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.swu.zzm.wechat.utils.UIUtils;

/**
 * @author Administrator
 * @描述 登录出错广播接收者
 */
public class AuthBroadcastReceiver extends BroadcastReceiver {

    public static String ACTION = AuthBroadcastReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(ACTION)) {

            int status = intent.getIntExtra("status", -1);
            if (status == FORBIDDEN.getValue()) {
                UIUtils.showToast("被服务器禁止登录");
            } else if (status == KICKOUT.getValue()) {
                UIUtils.showToast("被其他端的登录踢掉");
            } else if (status == KICK_BY_OTHER_CLIENT.getValue()) {
                UIUtils.showToast("被同时在线的其他端主动踢掉");
            } else if (status == PWD_ERROR.getValue()) {
                UIUtils.showToast("用户名或密码错误");
            }
            Intent i = new Intent(context, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        }

    }
}
