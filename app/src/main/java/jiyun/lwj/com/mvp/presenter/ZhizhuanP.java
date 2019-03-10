package jiyun.lwj.com.mvp.presenter;

import jiyun.lwj.com.mvp.base.BasePresenter;
import jiyun.lwj.com.mvp.bean.ZhizhuanBean;
import jiyun.lwj.com.mvp.model.ZhizhuanM;
import jiyun.lwj.com.mvp.net.ResultCallBack;
import jiyun.lwj.com.mvp.view.ZhizhuanV;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhizhuanP extends BasePresenter<ZhizhuanV> {

    private ZhizhuanM mZhizhuanM;

    @Override
    protected void initModel() {
        mZhizhuanM = new ZhizhuanM();
        mModels.add(mZhizhuanM);
    }

    public void initData() {
        mZhizhuanM.initData(new ResultCallBack<ZhizhuanBean>(){
            @Override
            public void onSuccess(ZhizhuanBean zhiRiBean) {
                if(mView != null){
                    mView.setData(zhiRiBean.getData());
                }
            }
        });
    }
}
