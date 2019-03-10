package jiyun.lwj.com.mvp.presenter;

import jiyun.lwj.com.mvp.base.BasePresenter;
import jiyun.lwj.com.mvp.model.MainModel;
import jiyun.lwj.com.mvp.view.MainView;

/**
 * Created by 她说 on 2019/3/10.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private MainModel mMainModel;

    @Override
    protected void initModel() {
        mMainModel = new MainModel();
        mModels.add(mMainModel);
    }
}
