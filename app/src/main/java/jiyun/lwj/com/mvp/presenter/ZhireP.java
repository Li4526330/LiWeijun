package jiyun.lwj.com.mvp.presenter;

import jiyun.lwj.com.mvp.base.BasePresenter;
import jiyun.lwj.com.mvp.bean.ZhiReBean;
import jiyun.lwj.com.mvp.model.ZhireM;
import jiyun.lwj.com.mvp.net.ResultCallBack;
import jiyun.lwj.com.mvp.view.ZhireV;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhireP extends BasePresenter<ZhireV> {

    private ZhireM mZhireM;

    @Override
    protected void initModel() {
        mZhireM = new ZhireM();
        mModels.add(mZhireM);
    }

    public void initData() {
        mZhireM.initData(new ResultCallBack<ZhiReBean>(){
            @Override
            public void onSuccess(ZhiReBean zhiRiBean) {
                if(mView != null){
                    mView.setData(zhiRiBean.getRecent());
                }
            }
        });
    }
}
