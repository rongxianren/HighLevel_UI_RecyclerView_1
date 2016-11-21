package com.rongxianren.highlevel_ui_recyclerview_1.customView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.rongxianren.highlevel_ui_recyclerview_1.adapter.WrapRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wty on 2016/11/21.
 */
public class WrapRecyclerView extends RecyclerView {

    private List<View> mHeaderViewList = new ArrayList<>();
    private List<View> mfooterViewList = new ArrayList<>();
    private Adapter adapter;


    public WrapRecyclerView(Context context) {
        this(context, null);
    }

    public WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (null == adapter) {
            throw new NullPointerException("can't set a null adapter!!!!");
        }
        if (mHeaderViewList.size() > 0 || mfooterViewList.size() > 0) {
            adapter = new WrapRecyclerViewAdapter(mHeaderViewList, mfooterViewList, adapter);
        } else {
            this.adapter = adapter;
        }
        super.setAdapter(adapter);
    }

    public void addHeaderView(View view) {
        mHeaderViewList.add(view);
        if (null != adapter) {
            adapter = new WrapRecyclerViewAdapter(mHeaderViewList, mfooterViewList, adapter);
        }
    }

    public void addFooterView(View view) {
        mfooterViewList.add(view);
        if (null != adapter) {
            adapter = new WrapRecyclerViewAdapter(mHeaderViewList, mfooterViewList, adapter);
        }
    }
}
