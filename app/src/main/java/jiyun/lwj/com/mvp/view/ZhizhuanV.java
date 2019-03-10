package jiyun.lwj.com.mvp.view;

import java.util.List;

import jiyun.lwj.com.mvp.base.BaseView;
import jiyun.lwj.com.mvp.bean.ZhizhuanBean;

/**
 * Created by 她说 on 2019/3/10.
 */

public interface ZhizhuanV extends BaseView {
    void setData(List<ZhizhuanBean.DataBean> data);
}
