package com.rongxianren.highlevel_ui_recyclerview_1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.rongxianren.highlevel_ui_recyclerview_1.adapter.ItemTouch_RecyclerView_Adapter;
import com.rongxianren.highlevel_ui_recyclerview_1.itemTouchHelper.ItemTouchHelperCallBack;
import com.rongxianren.highlevel_ui_recyclerview_1.iterface.StartDragListenerInter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 实现Item拖动效果
 */
public class RecyclerView_ItemTouchHelper_Activity extends AppCompatActivity implements StartDragListenerInter {


    private RecyclerView recyclerView;
    private final int[] icons = {R.mipmap.logo_1, R.mipmap.logo_2, R.mipmap.logo_3, R.mipmap.logo_4, R.mipmap.logo_5, R.mipmap.logo_6};
    private ItemTouchHelper itemTouchHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view__item_touch_helper_);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        List<Integer> data = new ArrayList();
        for (int i = 0; i < icons.length; i++) {
            data.add(icons[i]);
        }

        for (int i = icons.length - 1; i >= 0; i--) {
            data.add(icons[i]);
        }

        for (int i = 0; i < icons.length; i++) {
            data.add(icons[i]);
        }

        for (int i = icons.length - 1; i >= 0; i--) {
            data.add(icons[i]);
        }


        ItemTouch_RecyclerView_Adapter adapter = new ItemTouch_RecyclerView_Adapter(data, this);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new Decoration());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ItemTouchHelperCallBack callback = new ItemTouchHelperCallBack();
        callback.setItemTouchMoveListener(adapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }

    public class Decoration extends RecyclerView.ItemDecoration {

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 5, 0, 0);
        }
    }
}

