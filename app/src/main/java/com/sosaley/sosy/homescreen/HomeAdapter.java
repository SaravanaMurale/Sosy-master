package com.sosaley.sosy.homescreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.HomeItemResponse;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    Context context;
    List<HomeItemResponse> homeItemResponseList;
    HomeItemClickListener homeItemClickListener;

    public HomeAdapter(Context context, List<HomeItemResponse> homeItemResponseList, HomeItemClickListener homeItemClickListener) {
        this.context = context;
        this.homeItemResponseList = homeItemResponseList;
        this.homeItemClickListener = homeItemClickListener;
    }

    public void setData(List<HomeItemResponse> homeItemResponses) {
        this.homeItemResponseList = homeItemResponses;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.layout_home_adaper, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        Picasso.with(context).load(homeItemResponseList.get(position).getHomeImage()).into(holder.homeItemImage);
        holder.homeItemName.setText(homeItemResponseList.get(position).getHomeItemName());

    }

    @Override
    public int getItemCount() {
        return homeItemResponseList == null ? 0 : homeItemResponseList.size();
    }


    class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView homeItemImage;
        TextView homeItemName;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            homeItemImage = (ImageView) itemView.findViewById(R.id.itemImg);
            homeItemName = (TextView) itemView.findViewById(R.id.itemName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HomeItemResponse homeItemResponse = homeItemResponseList.get(getAdapterPosition());
                    homeItemClickListener.homeItemClick(homeItemResponse);
                }
            });

        }
    }

    interface HomeItemClickListener {

        void homeItemClick(HomeItemResponse homeItemResponse);

    }

}
