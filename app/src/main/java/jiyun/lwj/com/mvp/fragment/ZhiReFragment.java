package jiyun.lwj.com.mvp.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.adapter.ZhireAdapter;
import jiyun.lwj.com.mvp.base.BaseFragment;
import jiyun.lwj.com.mvp.bean.ZhiReBean;
import jiyun.lwj.com.mvp.presenter.ZhireP;
import jiyun.lwj.com.mvp.view.ZhireV;


public class ZhiReFragment extends BaseFragment<ZhireV, ZhireP> implements ZhireV {

    private XRecyclerView mRlv;
    private ArrayList<ZhiReBean.RecentBean> mList;
    private ZhireAdapter mAdapter;

    @Override
    protected ZhireP initPresenter() {
        return new ZhireP();
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
        mAdapter = new ZhireAdapter(getContext(),mList);
        mRlv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.initData();
    }

    @Override
    public void setData(List<ZhiReBean.RecentBean> recent) {
        mAdapter.setData(recent);
        mRlv.refreshComplete();
    }
}
