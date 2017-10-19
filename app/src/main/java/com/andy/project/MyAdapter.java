package com.andy.project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.adapter.CommAdapter;
import com.example.library.image.NetImageLoader;

import org.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 15:31
 */
public class MyAdapter extends CommAdapter<Data.ResultBean.DataBean,MyAdapter.ViewHolder>{


    public MyAdapter(Context context, List<Data.ResultBean.DataBean> list, int itemLayoutId) {
        super(context, list, itemLayoutId);
    }

    @Override
    public void setViewByHolder(ViewHolder holder, Data.ResultBean.DataBean dataBean, int position) {
        holder.title.setText(dataBean.getTitle());
        NetImageLoader.getInstance().display(dataBean.getThumbnail_pic_s(),holder.image);
    }

    @Override
    public ViewHolder getViewHolder() {
        return new ViewHolder();
    }

    class ViewHolder{
        @ViewInject(R.id.title)
        TextView title;
        @ViewInject(R.id.image)
        ImageView image;
    }
}
