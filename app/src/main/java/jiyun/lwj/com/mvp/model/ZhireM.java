package jiyun.lwj.com.mvp.model;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import jiyun.lwj.com.mvp.base.BaseModel;
import jiyun.lwj.com.mvp.bean.ZhiReBean;
import jiyun.lwj.com.mvp.net.ApiService;
import jiyun.lwj.com.mvp.net.HttpUtils;
import jiyun.lwj.com.mvp.net.ResultCallBack;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhireM extends BaseModel {

    private static final String TAG = "ZhireM";

    public void initData(final ResultCallBack<ZhiReBean> callBack) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.mZhihuUrl, ApiService.class);
        Observable<ZhiReBean> observable = apiserver.getZhiReData();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiReBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ZhiReBean zhiReBean) {
                        callBack.onSuccess(zhiReBean);
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
