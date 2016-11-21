package com.rongxianren.highlevel_ui_recyclerview_1.item_decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rongxianren.highlevel_ui_recyclerview_1.R;

/**
 * Created by wty on 2016/11/20.
 */

public class My_ItemDecoration extends RecyclerView.ItemDecoration {

    private Context mContext;
    private int mOrientation = LinearLayoutManager.VERTICAL;
    private Drawable mDivider;

    public My_ItemDecoration(Context context, int orientation) {
        this.mContext = context;
        mDivider = ContextCompat.getDrawable(mContext, R.drawable.item_divider);
        if (orientation != LinearLayoutManager.VERTICAL && orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException(" please enter a correct orientation params");
        }
        mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        System.out.println("------onDraw---------");
//        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
//            drawVerticalDivider(c, parent);
//        } else if (mOrientation == LinearLayoutManager.VERTICAL) {
//            drawHorizontalDivider(c, parent);
//        }
        drawVerticalDivider(c, parent);
        drawHorizontalDivider(c, parent);
    }

    private void drawVerticalDivider(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin;
            int top = child.getTop() - params.topMargin;
            int right = left + mDivider.getIntrinsicWidth();
            int bottom = child.getBottom() + params.bottomMargin;
            if (isLastColumn(child, parent)) {
                right = left;
            }
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    private void drawHorizontalDivider(Canvas c, RecyclerView parent) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = params.leftMargin;
            int top = child.getBottom() + params.bottomMargin;
            int right = child.getRight() + params.rightMargin;
            int bottom = top + mDivider.getIntrinsicHeight();
            if (isLastRaw(child, parent)) {
                bottom = top;
            }
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        /**
         * outRect 就是要来记录 各个item的  上下左右的  偏移距离的
         */
//        super.getItemOffsets(outRect, view, parent, state);
//        if (mOrientation == LinearLayoutManager.HORIZONTAL) {
//            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
//        } else {////mOrientation == LinearLayoutManager.VERTICAL
//            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
//        }

        int right = mDivider.getIntrinsicWidth();
        int bottom = mDivider.getIntrinsicHeight();

        if (isLastColumn(view, parent)) {
            right = 0;
        }

        if (isLastRaw(view, parent)) {
            bottom = 0;
        }

        outRect.set(0, 0, right, bottom);
    }

    private boolean isLastColumn(View view, RecyclerView parent) {
        int position = parent.getChildAdapterPosition(view);
        int spanCount = getSpanCount(parent);
        int totalCount = parent.getAdapter().getItemCount();

        if (0 == (position + 1) % (spanCount) || position == (totalCount - 1)) {
            return true;
        }
        return false;
    }


    private boolean isLastRaw(View view, RecyclerView parent) {
        int position = parent.getChildAdapterPosition(view);
        int spanCount = getSpanCount(parent);
        int totalCount = parent.getAdapter().getItemCount();

        int totalRaw = (int) Math.ceil((double) totalCount / (double) spanCount);

        int currentRaw = position / spanCount + 1;
        if (currentRaw == totalRaw) {
            return true;
        }
        return false;
    }

    private int getSpanCount(RecyclerView parent) {
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            return gridLayoutManager.getSpanCount();
        } else {
            throw new IllegalArgumentException("the layoutManager is not GridLayoutManager!!!");
        }
    }
}
