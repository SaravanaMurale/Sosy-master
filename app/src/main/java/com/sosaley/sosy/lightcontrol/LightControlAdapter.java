package com.sosaley.sosy.lightcontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.LightControlItems;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class LightControlAdapter extends RecyclerView.Adapter<LightControlAdapter.LightControlViewHolder> {

    Context context;
    List<LightControlItems> lightControlItemsList;
    LightControlItelClickListener lightControlItelClickListener;


    public LightControlAdapter(Context context, List<LightControlItems> lightControlItemsList, LightControlItelClickListener lightControlItelClickListener) {
        this.context = context;
        this.lightControlItemsList = lightControlItemsList;
        notifyDataSetChanged();
    }

    /*public void setData(List<Integer> lightControlItems) {
        this.lightControlItemsList = lightControlItems;
        notifyDataSetChanged();
    }*/


    @NonNull
    @Override
    public LightControlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_lightcontroladapter, parent, false);

        return new LightControlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LightControlViewHolder holder, int position) {

        // Picasso.with(context).load(homeItemResponseList.get(position).getHomeImage()).into(holder.homeItemImage);

        Picasso.with(context).load(lightControlItemsList.get(position).getLightControl_Img()).into(holder.lightImage);
        holder.lightName.setText(lightControlItemsList.get(position).getLightControl_LightName());

        if (lightControlItemsList.get(position).getLightControl_LightCount() > 0) {
            holder.dec.setEnabled(true);
            holder.count.setText("" + lightControlItemsList.get(position).getLightControl_LightCount());
        } else if (lightControlItemsList.get(position).getLightControl_LightCount() == 0) {
            holder.dec.setEnabled(false);
            holder.count.setText("" + lightControlItemsList.get(position).getLightControl_LightCount());
        }


    }

    @Override
    public int getItemCount() {
        return lightControlItemsList == null ? 0 : lightControlItemsList.size();
    }

    class LightControlViewHolder extends RecyclerView.ViewHolder {

        ImageView lightImage;
        TextView inc, dec, count, lightName;

        public LightControlViewHolder(@NonNull View itemView) {
            super(itemView);

            lightImage = (ImageView) itemView.findViewById(R.id.lightImg);
            lightName = (TextView) itemView.findViewById(R.id.lightName);
            inc = (TextView) itemView.findViewById(R.id.inc);
            dec = (TextView) itemView.findViewById(R.id.dec);
            count = (TextView) itemView.findViewById(R.id.lightCount);

            inc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    LightControlItems lightControlItems = lightControlItemsList.get(getAdapterPosition());

                    lightControlItems.setLightControl_LightCount(lightControlItems.getLightControl_LightCount() + 1);
                    notifyDataSetChanged();


                }
            });

            dec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LightControlItems lightControlItems = lightControlItemsList.get(getAdapterPosition());

                        lightControlItems.setLightControl_LightCount(lightControlItems.getLightControl_LightCount() - 1);

                        if (lightControlItems.getLightControl_LightCount() > 0) {
                            notifyDataSetChanged();
                        } else if (lightControlItems.getLightControl_LightCount() == 0) {
                            notifyDataSetChanged();
                        }

                    }

            });


        }


    }

    interface LightControlItelClickListener {

        public void lightControlItemClicked(LightControlItems lightControlItems);

    }

}
