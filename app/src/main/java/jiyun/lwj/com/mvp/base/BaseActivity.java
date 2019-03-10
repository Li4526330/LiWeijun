package jiyun.lwj.com.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by 她说 on 2019/3/10.
 */

public abstract class BaseActivity<V extends BaseView,T extends BasePresenter> extends AppCompatActivity {
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = initPresenter();
        if(mPresenter != null){
            mPresenter.attachView((V)this);
        }
        initData();
        initView();
        initListener();
    }

    protected void initView() {
    }
    protected void initListener() {
    }
    protected void initData() {
    }

    protected abstract T initPresenter();

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.onDestroy();
        }
    }
}
