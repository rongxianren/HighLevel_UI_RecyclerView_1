package com.rongxianren.highlevel_ui_recyclerview_1;

import android.graphics.Color;
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

    private RecyclerItemClick recyclerItemClick;

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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(data.get(position));
        int color = holder.textView.getResources().getColor(colors[random.nextInt(colors.length)]);
        holder.textView.setTextColor(Color.parseColor("#000000"));
        holder.textView.setBackgroundColor(color);

        if (null != recyclerItemClick)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerItemClick.itemClick(position);
                }
            });
    }

    @Override
    public int getItemCount() {
        return null == data ? 0 : data.size();
    }

    public void addData(String item) {
        data.add(3, item);
        this.notifyItemInserted(3);
    }

    public void removeItem(int position) {
        if (position > 0 && position < data.size()) {
            data.remove(position);
            this.notifyItemRemoved(position);
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }


    public void setOnItemClickListener(RecyclerItemClick listener) {
        this.recyclerItemClick = listener;
    }

    public interface RecyclerItemClick {
        void itemClick(int position);
    }
}


