package com.rongxianren.highlevel_ui_recyclerview_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.rongxianren.highlevel_ui_recyclerview_1.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * author wty
 * date 2016/11/18
 */
public class RecyclerViewActivity extends AppCompatActivity implements MyRecyclerViewAdapter.RecyclerItemClick {


    private RecyclerView recyclerView;
    private String[] data = {"hello word", "wty is hero", "I love fishC", "hahhhahahhahahah", "bitch"};
    private boolean layoutFlag = true;
    private MyRecyclerViewAdapter myRecyclerViewAdapter = null;
    private Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        List<String> dataList = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            random = new Random();
            dataList.add(data[random.nextInt(data.length)]);
        }
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataList);
        myRecyclerViewAdapter.setOnItemClickListener(this);
//      recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//      recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//      recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());////添加默认item动画效果

    }


    /**
     * 可以动态的切换  item的布局效果
     *
     * @param view
     */
    public void change(View view) {
        if (layoutFlag) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            layoutFlag = false;
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false));
            layoutFlag = true;
        }
    }

    public void addItem(View view) {
        myRecyclerViewAdapter.addData("heehhehe" + random.nextInt(100));
    }

    public void removeItem(View view) {
        myRecyclerViewAdapter.removeItem(4);
    }


    @Override
    public void itemClick(int position) {
        Toast.makeText(this, "------点我干嘛------" + position, Toast.LENGTH_SHORT).show();
    }
}
