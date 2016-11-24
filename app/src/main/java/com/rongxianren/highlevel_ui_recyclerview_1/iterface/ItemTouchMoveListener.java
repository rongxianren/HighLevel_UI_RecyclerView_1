package com.rongxianren.highlevel_ui_recyclerview_1.iterface;

/**
 * Created by wty on 2016/11/24.
 */

public interface ItemTouchMoveListener {
    void onRemove(int position);

    void onItemMove(int fromPosition, int toPosition);
}
