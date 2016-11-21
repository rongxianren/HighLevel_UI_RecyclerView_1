package com.rongxianren.highlevel_ui_recyclerview_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.rongxianren.highlevel_ui_recyclerview_1.adapter.MyRecyclerViewAdapter;
import com.rongxianren.highlevel_ui_recyclerview_1.customView.WrapRecyclerView;
import com.rongxianren.highlevel_ui_recyclerview_1.item_decoration.My_ItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Header_WrappRecyclerView extends AppCompatActivity {

    private WrapRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header__wrapp_recycler_view);
        recyclerView = (WrapRecyclerView) findViewById(R.id.wrap_recycler_view);

        List<String> dataList = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            dataList.add("Item-" + i);
        }
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataList);

        View view = LayoutInflater.from(this).inflate(R.layout.recyclerview_header, null, false);
        recyclerView.addHeaderView(view);
        recyclerView.addHeaderView(view);
        recyclerView.addFooterView(view);

        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new My_ItemDecoration(this, LinearLayoutManager.VERTICAL));

//        ListView listView = new ListView(this);
//        listView.addHeaderView();
    }
}
