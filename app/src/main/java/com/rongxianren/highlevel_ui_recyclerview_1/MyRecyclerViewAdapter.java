package com.rongxianren.highlevel_ui_recyclerview_1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by wty on 2016/11/16.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<String> data;
    private int[] colors = {R.color.colorAccent, R.color.colorBlue, R.color.colorGreen, R.color.colorPrimary, R.color.colorPrimaryDark};
    private Random random = new Random();

    public MyRecyclerViewAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
        int color = holder.textView.getResources().getColor(colors[random.nextInt(colors.length)]);
        holder.textView.setTextColor(color);
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }

    }
}

