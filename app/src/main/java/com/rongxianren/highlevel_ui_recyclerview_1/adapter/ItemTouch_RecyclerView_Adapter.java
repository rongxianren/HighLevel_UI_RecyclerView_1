package com.rongxianren.highlevel_ui_recyclerview_1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rongxianren.highlevel_ui_recyclerview_1.R;
import com.rongxianren.highlevel_ui_recyclerview_1.iterface.ItemTouchMoveListener;
import com.rongxianren.highlevel_ui_recyclerview_1.iterface.StartDragListenerInter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wty on 2016/11/23.
 */

public class ItemTouch_RecyclerView_Adapter extends RecyclerView.Adapter<ItemTouch_RecyclerView_Adapter.MyViewHolder> implements ItemTouchMoveListener {

    private List<Integer> data = new ArrayList<>();
    private StartDragListenerInter startDragListenerInter;

    public ItemTouch_RecyclerView_Adapter(List<Integer> dataList, StartDragListenerInter listenerInter) {
        this.data = dataList;
        this.startDragListenerInter = listenerInter;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_touch_recyclerview_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.icon.setImageResource(data.get(position));
        holder.icon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startDragListenerInter.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }


    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(data, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onRemove(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }
}

