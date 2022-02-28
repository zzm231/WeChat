package com.swu.zzm.wechat.factory;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ListView;

import com.swu.zzm.wechat.utils.UIUtils;

/**
 * @author Administrator
 * @描述 ListView工厂（已经配置好了样式）
 */
public class ListViewFactory {

    public static ListView createListView() {
        ListView listView = new ListView(UIUtils.getContext());

        // 简单的设置
        listView.setCacheColorHint(Color.TRANSPARENT);
        listView.setFastScrollEnabled(true);

        //去掉listview的item点击时的蓝色背景
        listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        return listView;
    }
}
