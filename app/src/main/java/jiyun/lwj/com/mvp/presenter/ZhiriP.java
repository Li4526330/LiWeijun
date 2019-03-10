package jiyun.lwj.com.mvp.presenter;

import android.util.Log;

import jiyun.lwj.com.mvp.base.BasePresenter;
import jiyun.lwj.com.mvp.bean.ZhiRiBean;
import jiyun.lwj.com.mvp.model.ZhiriM;
import jiyun.lwj.com.mvp.net.ResultCallBack;
import jiyun.lwj.com.mvp.view.ZhiriV;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhiriP extends BasePresenter<ZhiriV> {
    private static final String TAG = "ZhiriP";
    private ZhiriM mZhiriM;
    @Override
    protected void initModel() {
        mZhiriM = new ZhiriM();
        mModels.add(mZhiriM);
    }

    public void initData() {
        mZhiriM.initData(new ResultCallBack<ZhiRiBean>(){

            @Override
            public void onSuccess(ZhiRiBean zhiRiBean) {
                if(mView != null){
                    Log.d(TAG, "onSuccess: "+zhiRiBean.getDate());
                    mView.getData(zhiRiBean);
                }
            }
        });
    }
}
