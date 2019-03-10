package jiyun.lwj.com.mvp.model;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jiyun.lwj.com.mvp.base.BaseModel;
import jiyun.lwj.com.mvp.bean.ZhiRiBean;
import jiyun.lwj.com.mvp.net.ApiService;
import jiyun.lwj.com.mvp.net.HttpUtils;
import jiyun.lwj.com.mvp.net.ResultCallBack;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhiriM extends BaseModel {
    private static final String TAG = "ZhiriM";

    public void initData(final ResultCallBack<ZhiRiBean> callBack) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.mZhihuUrl, ApiService.class);
        Observable<ZhiRiBean> observable = apiserver.getZhiriData();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiRiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhiRiBean zhiRiBean) {
                        callBack.onSuccess(zhiRiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
