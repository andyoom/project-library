package com.andy.project;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.library.BaseActvity;
import com.example.library.http.MyCallback;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActvity {
    private String urlPath ="http://v.juhe.cn/toutiao/index?type=top&key=2f092bd9ce76c0257052d6d3c93c11b4";
    @ViewInject(R.id.lv)
    private ListView lv;
    private List<Data.ResultBean.DataBean> list=new ArrayList<>();
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter=new MyAdapter(this,list,R.layout.item);
        lv.setAdapter(adapter);

        loadData();
    }

    private void loadData() {
        http().get(urlPath, new MyCallback<Data>() {
            @Override
            public void success(Data data) {
                list.addAll(data.getResult().getData());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void error(Throwable ex) {
                Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
