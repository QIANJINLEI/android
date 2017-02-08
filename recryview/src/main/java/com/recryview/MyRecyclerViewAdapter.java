package com.recryview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wb-qjl256634 on 2017/2/8.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private  ArrayList<String> data  =new ArrayList<>();
    private onClick click;

    public MyRecyclerViewAdapter(ArrayList<String> data) {
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.item_home, parent,
                false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.textView.setText(data.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (click!=null){
                    click.click(view,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.id_num);

        }
    }
    public void setOnClick(onClick click){
        this.click=click;
    };
     interface onClick{
        void click(View itemView,int postion);
    }
}
