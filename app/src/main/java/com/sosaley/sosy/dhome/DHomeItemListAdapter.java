package com.sosaley.sosy.dhome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sosaley.sosy.R;

public class DHomeItemListAdapter extends RecyclerView.Adapter<DHomeItemListAdapter.DHomeItemListViewHolder> implements HomeItemClickable {

    private Context mCtx;

    HomeItemClickable homeItemClickable;

    @Override
    public void onHomeItemClick() {

    }



    @NonNull
    @Override
    public DHomeItemListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(mCtx);
        View view=layoutInflater.inflate(R.layout.layout_dhome_itemlist_adapter,parent,false);

        return new DHomeItemListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DHomeItemListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class DHomeItemListViewHolder extends RecyclerView.ViewHolder{

        public DHomeItemListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
