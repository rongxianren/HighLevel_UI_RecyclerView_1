package com.rongxianren.highlevel_ui_recyclerview_1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wty on 2016/11/21.
 */

public class WrapRecyclerViewAdapter extends RecyclerView.Adapter {

    private List<View> mHeaderViews = new ArrayList<>();
    private List<View> mFooterViews = new ArrayList<>();
    private RecyclerView.Adapter recyclerViewAdapter;

    private final int HEADER_VIEW_TYPE = -2;
    private final int FOTTER_VIEW_TYPR = -3;

    public WrapRecyclerViewAdapter(List<View> mHeaderViews, List<View> mFooterViews, RecyclerView.Adapter recyclerViewAdapter) {
        this.mHeaderViews = mHeaderViews;
        this.mFooterViews = mFooterViews;
        this.recyclerViewAdapter = recyclerViewAdapter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER_VIEW_TYPE) {
            return new HeaderViewHolder(mHeaderViews.get(0));////随便放个View进去就可以了
        } else if (viewType == FOTTER_VIEW_TYPR) {
            return new HeaderViewHolder(mFooterViews.get(0));
        }
        return recyclerViewAdapter.onCreateViewHolder(parent, viewType);/////调用实际adapter的 onCreateViewHolder方法
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //头部
        int headerCount = mHeaderViews.size();
        if (position < headerCount) {
            return;
        }

        /// adapter 部分
        int itemPosition = position - headerCount;
        if (recyclerViewAdapter != null && itemPosition < recyclerViewAdapter.getItemCount()) {
            recyclerViewAdapter.onBindViewHolder(holder, itemPosition);////调用实际adapter的 onBindViewHolder方法
        }
        ///尾部
        //什么都不用做
    }

    @Override
    public int getItemViewType(int position) {
        int headerCount = mHeaderViews.size();
        if (position < headerCount) {
            return HEADER_VIEW_TYPE;
        }
        int itemPosition = position - headerCount;
        if (null != recyclerViewAdapter && itemPosition < recyclerViewAdapter.getItemCount()) {
            return recyclerViewAdapter.getItemViewType(itemPosition);
        }
        return FOTTER_VIEW_TYPR;
    }

    @Override
    public int getItemCount() {
        if (null != recyclerViewAdapter) {
            return recyclerViewAdapter.getItemCount() + mHeaderViews.size() + mFooterViews.size();
        } else {
            return mHeaderViews.size() + mFooterViews.size();
        }

    }

    public int getHeadersCount() {
        return mHeaderViews.size();
    }

    public int getFootersCount() {
        return mFooterViews.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }


}
