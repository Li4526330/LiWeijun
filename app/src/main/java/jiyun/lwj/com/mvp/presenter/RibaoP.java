package jiyun.lwj.com.mvp.presenter;

import jiyun.lwj.com.mvp.base.BasePresenter;
import jiyun.lwj.com.mvp.model.RibaoM;

/**
 * Created by 她说 on 2019/3/10.
 */

public class RibaoP extends BasePresenter {

    private RibaoM mRibaoM;

    @Override
    protected void initModel() {
        mRibaoM = new RibaoM();
        mModels.add(mRibaoM);
    }

}
