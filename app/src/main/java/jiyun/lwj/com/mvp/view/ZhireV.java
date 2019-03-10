package jiyun.lwj.com.mvp.view;

import java.util.List;

import jiyun.lwj.com.mvp.base.BaseView;
import jiyun.lwj.com.mvp.bean.ZhiReBean;

/**
 * Created by 她说 on 2019/3/10.
 */

public interface ZhireV extends BaseView {
    void setData(List<ZhiReBean.RecentBean> recent);
}
