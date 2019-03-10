package jiyun.lwj.com.mvp.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by 她说 on 2019/3/10.
 */

public abstract class BaseModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public void onDestroy() {
        mCompositeDisposable.clear();
    }
}
