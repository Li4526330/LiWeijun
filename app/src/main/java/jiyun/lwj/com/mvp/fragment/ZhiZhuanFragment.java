package jiyun.lwj.com.mvp.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.adapter.ZhizhuanAdapter;
import jiyun.lwj.com.mvp.base.BaseFragment;
import jiyun.lwj.com.mvp.bean.ZhizhuanBean;
import jiyun.lwj.com.mvp.presenter.ZhizhuanP;
import jiyun.lwj.com.mvp.view.ZhizhuanV;

public class ZhiZhuanFragment extends BaseFragment<ZhizhuanV, ZhizhuanP> implements ZhizhuanV {

    @BindView(R.id.rlv)
    XRecyclerView mRlv;
    private ArrayList<ZhizhuanBean.DataBean> mList;
    private ZhizhuanAdapter mAdapter;

    @Override
    protected ZhizhuanP initPresenter() {
        return new ZhizhuanP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zhiri;
    }

    @Override
    protected void initView(View inflate) {
        super.initView(inflate);
        mRlv.setLayoutManager(new GridLayoutManager(getContext(),2));
        mList = new ArrayList<>();
        mAdapter = new ZhizhuanAdapter(getContext(),mList);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.initData();
    }

    @Override
    public void setData(List<ZhizhuanBean.DataBean> data) {
        mAdapter.setData(data);
    }
}
