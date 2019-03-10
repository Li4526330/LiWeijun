package jiyun.lwj.com.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.bean.ZhiReBean;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhireAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final ArrayList<ZhiReBean.RecentBean> mList;

    public ZhireAdapter(Context context, ArrayList<ZhiReBean.RecentBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.zhireitem, null, false);
        return new ArticleViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArticleViewHolder holder1 = (ArticleViewHolder) holder;
        ZhiReBean.RecentBean bean = mList.get(position);
        holder1.mZhireTitle.setText(bean.getTitle());
        Glide.with(mContext).load(bean.getUrl()).placeholder(R.mipmap.ic_launcher).into(holder1.mZhireImg);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ZhiReBean.RecentBean> recent) {
        mList.addAll(recent);
        notifyDataSetChanged();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mZhireImg;
        private final TextView mZhireTitle;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            this.mZhireImg = (ImageView) itemView.findViewById(R.id.zhire_img);
            this.mZhireTitle = (TextView) itemView.findViewById(R.id.zhire_title);
        }
    }
}
