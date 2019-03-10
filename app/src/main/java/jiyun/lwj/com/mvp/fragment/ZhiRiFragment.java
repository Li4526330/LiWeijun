package jiyun.lwj.com.mvp.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.adapter.ZhiriAdapter;
import jiyun.lwj.com.mvp.base.BaseFragment;
import jiyun.lwj.com.mvp.bean.ZhiRiBean;
import jiyun.lwj.com.mvp.presenter.ZhiriP;
import jiyun.lwj.com.mvp.view.ZhiriV;

public class ZhiRiFragment extends BaseFragment<ZhiriV, ZhiriP> implements ZhiriV {


    private XRecyclerView mRlv;
    private ArrayList<ZhiRiBean.StoriesBean> mList;
    private ArrayList<ZhiRiBean.TopStoriesBean> mBannerlist;
    private ZhiriAdapter mAdapter;

    @Override
    protected ZhiriP initPresenter() {
        return new ZhiriP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zhiri;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mRlv = (XRecyclerView) inflate.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mList = new ArrayList<>();
        mBannerlist = new ArrayList<>();
        mAdapter = new ZhiriAdapter(getContext(),mList,mBannerlist);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.initData();
    }

    @Override
    public void getData(ZhiRiBean zhiRiBean) {
        mAdapter.setData(zhiRiBean);
        mRlv.refreshComplete();
    }
}
