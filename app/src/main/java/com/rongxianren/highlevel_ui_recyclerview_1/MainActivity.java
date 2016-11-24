package com.rongxianren.highlevel_ui_recyclerview_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

/**
 * author wty
 * date 2016/11/18
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_acitvity_layout);
    }

    public void go_recyclerView(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    public void go_ItemDecoration_View(View view) {
        Intent intent = new Intent(this, RecyclerView_ItemDecoration_Activity.class);
        startActivity(intent);
    }

    public void go_Header_RecyclerView(View view) {
        Intent intent = new Intent(this, Header_WrappRecyclerViewActivity.class);
        startActivity(intent);
    }

    public void go_ItemTouchHelper_RecyclerView(View view) {
        Intent intent = new Intent(this, RecyclerView_ItemTouchHelper_Activity.class);
        startActivity(intent);
    }
}
