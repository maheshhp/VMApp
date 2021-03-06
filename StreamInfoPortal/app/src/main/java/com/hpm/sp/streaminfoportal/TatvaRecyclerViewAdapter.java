package com.hpm.sp.streaminfoportal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.*;

/**
 * Created by mahesh on 22/04/17.
 */

public class TatvaRecyclerViewAdapter extends RecyclerView.Adapter<TatvaRecyclerViewAdapter
        .DataObjectHolder>  {

    private ArrayList<TatvaDataObject> tatvaDataset;
    private static MyClickListener myClickListener;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView nameLabel;
        TextView dateTime;
        TextView artLoc;

        public DataObjectHolder(View itemView) {
            super(itemView);
            nameLabel = (TextView) itemView.findViewById(R.id.tatvaName);
            dateTime = (TextView) itemView.findViewById(R.id.tatvaAuthor);
            artLoc = (TextView) itemView.findViewById(R.id.artLoc);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public TatvaRecyclerViewAdapter(ArrayList<TatvaDataObject> myDataset) {
        tatvaDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tatva_card_list_row, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.nameLabel.setText(tatvaDataset.get(position).getNameText());
        holder.dateTime.setText(tatvaDataset.get(position).getAuthorText());
        holder.artLoc.setText(tatvaDataset.get(position).getFileLocation());
    }


    @Override
    public int getItemCount() {
        int i=0;
        try{
            i = tatvaDataset.size();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
        return i;
    }

    public interface MyClickListener {
        void onItemClick(int position, View v);
    }
}
