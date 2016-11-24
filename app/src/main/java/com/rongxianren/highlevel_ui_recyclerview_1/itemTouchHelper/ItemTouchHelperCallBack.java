package com.rongxianren.highlevel_ui_recyclerview_1.itemTouchHelper;

import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.rongxianren.highlevel_ui_recyclerview_1.R;
import com.rongxianren.highlevel_ui_recyclerview_1.iterface.ItemTouchMoveListener;

/**
 * Created by wty on 2016/11/23.
 */

public class ItemTouchHelperCallBack extends ItemTouchHelper.Callback {

    private ItemTouchMoveListener itemTouchMoveListener = null;

    public void setItemTouchMoveListener(ItemTouchMoveListener itemTouchMoveListener) {
        this.itemTouchMoveListener = itemTouchMoveListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        int swipeFlags = ItemTouchHelper.LEFT;
        int movementFlags = makeMovementFlags(dragFlags, swipeFlags);
        return movementFlags;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder srcHolder, RecyclerView.ViewHolder targetHolder) {
        if (null != itemTouchMoveListener) {
            itemTouchMoveListener.onItemMove(srcHolder.getAdapterPosition(), targetHolder.getAdapterPosition());
        }
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (null != itemTouchMoveListener) {
            itemTouchMoveListener.onRemove(viewHolder.getAdapterPosition());
        }
    }

    @Override
    public boolean isLongPressDragEnabled() {////是否长安能够拖动
        return false;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setAlpha(0.5f);
            int color = viewHolder.itemView.getResources().getColor(R.color.colorRed);
            viewHolder.itemView.setBackgroundColor(color);
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setAlpha(1);
        viewHolder.itemView.setBackgroundColor(Color.parseColor("#CCCCCC"));
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

    }

}

