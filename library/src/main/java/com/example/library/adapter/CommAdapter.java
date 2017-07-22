package com.example.library.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.xutils.x;

import java.util.List;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/7/13 15:32
 */
public abstract class CommAdapter<T,H> extends BaseAdapter{
    private Context context;
    private List<T> list;
    private int itemLayoutId;
    public CommAdapter(Context context, List<T> list,int itemLayoutId) {
        this.context = context;
        this.list = list;
        this.itemLayoutId=itemLayoutId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        H holder=null;
        if(convertView==null){
            convertView=View.inflate(context,itemLayoutId,null);
            holder=getViewHolder();

            x.view().inject(holder,convertView);

            convertView.setTag(holder);
        }else {
            holder= (H) convertView.getTag();
        }
        T t = list.get(position);

        setViewByHolder(holder,t ,position);

        return convertView;
    }

    public Context getContext() {
        return context;
    }

    public List<T> getList() {
        return list;
    }

    public abstract void setViewByHolder(H holder, T t,int position);
    public abstract H getViewHolder();
}
