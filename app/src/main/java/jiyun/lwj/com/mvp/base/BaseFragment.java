package jiyun.lwj.com.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.presenter.RibaoP;
import jiyun.lwj.com.mvp.view.RibaoV;

/**
 * Created by 她说 on 2019/3/10.
 */

public abstract class BaseFragment<V extends BaseView,T extends BasePresenter> extends Fragment{
    protected T mPresenter;
    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        mPresenter = initPresenter();
        mBind = ButterKnife.bind(this, inflate);
        if(mPresenter != null){
            mPresenter.attachView((V)this);
        }
        initView(inflate);
        initData();
        return inflate;
    }

    protected abstract T initPresenter();

    protected void initData() {

    }

    protected void initView(View inflate) {

    }

    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
        if(mPresenter != null){
            mPresenter.onDestroy();
        }
    }
}
