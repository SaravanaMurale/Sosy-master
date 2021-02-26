package com.sosaley.sosy.dhome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sosaley.sosy.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> implements HomeClickable  {

    Context mCtx;
    List<HomeResponse> homeResponseList;

    HomeClickable homeClickable;

    @Override
    public void onHomeClick(HomeResponse homeResponse) {

    }

    public HomeAdapter(Context mCtx, List<HomeResponse> homeResponseList, HomeClickable homeClickable) {
        this.mCtx = mCtx;
        this.homeResponseList = homeResponseList;
        this.homeClickable = homeClickable;
    }

    public void setData(List<HomeResponse> homeResponseList){
        this.homeResponseList=homeResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(mCtx);

        View view=layoutInflater.inflate(R.layout.layout_d_home_adapter,parent,false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return homeResponseList==null?0:homeResponseList.size();
    }



    class HomeViewHolder extends RecyclerView.ViewHolder{

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //homeClickable.onHomeClick();
                }
            });

        }
    }

}
