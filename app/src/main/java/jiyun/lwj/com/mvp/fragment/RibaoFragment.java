package jiyun.lwj.com.mvp.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.adapter.Ribao_VpAdapter;
import jiyun.lwj.com.mvp.base.BaseFragment;
import jiyun.lwj.com.mvp.bean.ZhiRiBean;
import jiyun.lwj.com.mvp.presenter.RibaoP;
import jiyun.lwj.com.mvp.view.RibaoV;

/**
 * Created by 她说 on 2019/3/10.
 */

public class RibaoFragment extends BaseFragment<RibaoV, RibaoP> implements RibaoV {

    private TabLayout mRibaoTab;
    private ViewPager mRibaoVp;
    private ArrayList<String> mTitle;
    private ArrayList<Fragment> mFragments;

    @Override
    protected RibaoP initPresenter() {
        return new RibaoP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ribao;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mRibaoTab = (TabLayout) inflate.findViewById(R.id.ribao_tab);
        mRibaoVp = (ViewPager) inflate.findViewById(R.id.ribao_vp);

    }

    @Override
    protected void initData() {
        super.initData();
        mTitle = new ArrayList<>();
        mTitle.add("日报");
        mTitle.add("专栏");
        mTitle.add("热门");
        mFragments = new ArrayList<>();
        mFragments.add(new ZhiRiFragment());
        mFragments.add(new ZhiZhuanFragment());
        mFragments.add(new ZhiReFragment());
        Ribao_VpAdapter adapter = new Ribao_VpAdapter(getChildFragmentManager(),mFragments,mTitle);
        mRibaoVp.setAdapter(adapter);
        mRibaoTab.setupWithViewPager(mRibaoVp);
    }

}
