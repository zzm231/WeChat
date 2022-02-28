package com.swu.zzm.wechat.fragment;



import android.content.Intent;
import android.view.View;

import com.swu.zzm.wechat.R;
import com.swu.zzm.wechat.view.AppConst;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator
 * @描述 发现
 */
public class DiscoveryFragment extends BaseFragment {

    private Intent mIntent;

    @OnClick({R.id.oivScan, R.id.oivNearby, R.id.oivShop, R.id.oivGame})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.oivScan:
                startActivity(new Intent(getActivity(), ScanActivity.class));
                break;
            case R.id.oivNearby:
                startActivity(new Intent(getActivity(), NearbyPeopleActivity.class));
                break;
            case R.id.oivShop:
                mIntent = new Intent(getActivity(), WebViewActivity.class);
                mIntent.putExtra("url", AppConst.Url.SHOP);
                mIntent.putExtra("title", "京东购物");
                startActivity(mIntent);
                break;
            case R.id.oivGame:
                mIntent = new Intent(getActivity(), WebViewActivity.class);
                mIntent.putExtra("url", AppConst.Url.GAME);
                mIntent.putExtra("title", "微信游戏");
                startActivity(mIntent);
                break;
        }
    }

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_discovery, null);
        ButterKnife.inject(this, view);
        return view;
    }
}

