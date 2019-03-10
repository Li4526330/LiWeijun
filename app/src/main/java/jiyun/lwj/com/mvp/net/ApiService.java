package jiyun.lwj.com.mvp.net;

import io.reactivex.Observable;
import jiyun.lwj.com.mvp.bean.ZhiReBean;
import jiyun.lwj.com.mvp.bean.ZhiRiBean;
import jiyun.lwj.com.mvp.bean.ZhizhuanBean;
import retrofit2.http.GET;

/**
 * Created by 她说 on 2019/3/10.
 */

public interface ApiService {

    String mZhihuUrl = "http://news-at.zhihu.com/api/4/";
    @GET("news/latest")
    Observable<ZhiRiBean> getZhiriData();

    @GET("sections")
    Observable<ZhizhuanBean> getZhizhuanData();

    @GET("news/hot")
    Observable<ZhiReBean> getZhiReData();
}
