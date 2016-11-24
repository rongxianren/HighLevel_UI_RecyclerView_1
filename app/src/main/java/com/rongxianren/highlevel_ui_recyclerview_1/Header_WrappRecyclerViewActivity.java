package com.rongxianren.highlevel_ui_recyclerview_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView.LayoutParams;

import com.rongxianren.highlevel_ui_recyclerview_1.adapter.MyRecyclerViewAdapter;
import com.rongxianren.highlevel_ui_recyclerview_1.customView.WrapRecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Header_WrappRecyclerViewActivity extends AppCompatActivity {

    private WrapRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header__wrapp_recycler_view);
        recyclerView = (WrapRecyclerView) findViewById(R.id.wrap_recycler_view);

        List<String> dataList = new ArrayList();
        for (int i = 0; i < 30; i++) {
            dataList.add("Item-" + i);
        }
        MyRecyclerViewAdapter myRecyclerViewAdapter = new MyRecyclerViewAdapter(dataList);

        View view = LayoutInflater.from(this).inflate(R.layout.recyclerview_header, null, false);
        LayoutParams params = new RecyclerView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Header_WrappRecyclerViewActivity.this, "点我 干嘛!!!", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.addHeaderView(view);
        recyclerView.addFooterView(view);

        recyclerView.setAdapter(myRecyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}
