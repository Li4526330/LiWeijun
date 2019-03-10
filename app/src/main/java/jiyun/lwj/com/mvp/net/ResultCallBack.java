package jiyun.lwj.com.mvp.net;

import jiyun.lwj.com.mvp.bean.ZhiRiBean;

/**
 * Created by 她说 on 2019/3/10.
 */

public interface ResultCallBack<T> {

    void onSuccess(T zhiRiBean);
}
