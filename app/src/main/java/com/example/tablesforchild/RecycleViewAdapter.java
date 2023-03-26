package com.example.tablesforchild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    List<String> mData;
    LayoutInflater mLayoutInflater;
    RecycleViewAdapter(List<String> mData, Context context){
        this.mData=mData;
        this.mLayoutInflater=LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=mLayoutInflater.inflate(R.layout.recycleview_table,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tableStr=mData.get(position);
        holder.mTextviewTables.setText(tableStr);

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextviewTables;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            mTextviewTables=itemView.findViewById(R.id.tv_table);
        }
    }
}
