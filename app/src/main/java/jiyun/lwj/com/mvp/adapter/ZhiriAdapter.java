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
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.bean.ZhiRiBean;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhiriAdapter extends RecyclerView.Adapter {

    private final Context mContext;
    private final ArrayList<ZhiRiBean.StoriesBean> mList;
    private final ArrayList<ZhiRiBean.TopStoriesBean> mBannerlist;

    public ZhiriAdapter(Context context, ArrayList<ZhiRiBean.StoriesBean> list, ArrayList<ZhiRiBean.TopStoriesBean> bannerlist) {
        mContext = context;
        mList = list;
        mBannerlist = bannerlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater from = LayoutInflater.from(mContext);
        if (viewType == 0) {
            View inflate = from.inflate(R.layout.item_banner, null, false);
            return new BannerViewHolder(inflate);
        } else if (viewType == 1) {
            View inflate = from.inflate(R.layout.item_time, null, false);
            return new TimeViewHolder(inflate);
        } else {
            View inflate = from.inflate(R.layout.item_news, null, false);
            return new NewsViewHolder(inflate);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType == 0){
            BannerViewHolder holder1 = (BannerViewHolder) holder;
            holder1.mBanner.setImages(mBannerlist).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    ZhiRiBean.TopStoriesBean path1 = (ZhiRiBean.TopStoriesBean) path;
                    Glide.with(mContext).load(path1.getImage()).placeholder(R.mipmap.ic_launcher).into(imageView);
                }
            }).start();
        }else if(itemViewType == 1){
            TimeViewHolder holder1 = (TimeViewHolder) holder;
            holder1.mTvTime.setText("今日热闻");
        }else{
            int newsPosition = position-1;
            if(mBannerlist.size() > 0){
                newsPosition -= 1;
            }
            NewsViewHolder holder1 = (NewsViewHolder) holder;
            ZhiRiBean.StoriesBean storiesBean = mList.get(newsPosition);
            holder1.mZhiriTv.setText(storiesBean.getTitle());
            Glide.with(mContext).load(storiesBean.getImages().get(0)).placeholder(R.mipmap.ic_launcher).into(holder1.mZhiriImg);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mBannerlist.size() > 0) {
            if (position == 0) {
                return 0;
            } else if (position == 1) {
                return 1;
            } else {
                return 2;
            }
        } else {
            if (position == 0) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (mBannerlist.size() > 0) {
            return mList.size() + 1 + 1;
        } else {
            return mList.size() + 1;
        }
    }

    public void setData(ZhiRiBean zhiRiBean) {
        mList.clear();
        List<ZhiRiBean.StoriesBean> list1 = zhiRiBean.getStories();
        mList.addAll(list1);
        mBannerlist.clear();
        mBannerlist.addAll(zhiRiBean.getTop_stories());
        notifyDataSetChanged();
    }


    static class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner mBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            this.mBanner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    static class TimeViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTime;

        public TimeViewHolder(View itemView) {
            super(itemView);
            this.mTvTime = (TextView) itemView.findViewById(R.id.tv_time);
        }
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView mZhiriImg;
        TextView mZhiriTv;

        public NewsViewHolder(View itemView) {
            super(itemView);
            this.mZhiriImg = (ImageView) itemView.findViewById(R.id.zhiri_img);
            this.mZhiriTv = (TextView) itemView.findViewById(R.id.zhiri_tv);
        }
    }
}
