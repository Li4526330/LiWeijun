package jiyun.lwj.com.mvp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import jiyun.lwj.com.mvp.R;
import jiyun.lwj.com.mvp.bean.ZhizhuanBean;

/**
 * Created by 她说 on 2019/3/10.
 */

public class ZhizhuanAdapter extends RecyclerView.Adapter {
    private final Context mContext;
    private final ArrayList<ZhizhuanBean.DataBean> mList;

    public ZhizhuanAdapter(Context context, ArrayList<ZhizhuanBean.DataBean> list) {

        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.zhizhuanitem, null, false);
        return new ArtileViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArtileViewHolder holder1 = (ArtileViewHolder) holder;
        ZhizhuanBean.DataBean bean = mList.get(position);
        holder1.mZhuanDesc.setText(bean.getDescription());
        holder1.mZhuanName.setText(bean.getName());
        Glide.with(mContext).load(bean.getThumbnail()).placeholder(R.mipmap.ic_launcher).into(holder1.mZhuanImg);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<ZhizhuanBean.DataBean> data) {
        mList.addAll(data);
        notifyDataSetChanged();
    }

    class ArtileViewHolder extends RecyclerView.ViewHolder{
        ImageView mZhuanImg;
        TextView mZhuanDesc;
        TextView mZhuanName;
        RelativeLayout mRr;

        public ArtileViewHolder(View itemView) {
            super(itemView);
            this.mZhuanImg = (ImageView) itemView.findViewById(R.id.zhuan_img);
            this.mZhuanDesc = (TextView) itemView.findViewById(R.id.zhuan_desc);
            this.mZhuanName = (TextView) itemView.findViewById(R.id.zhuan_name);
            this.mRr = (RelativeLayout) itemView.findViewById(R.id.rr);
        }
    }
}
