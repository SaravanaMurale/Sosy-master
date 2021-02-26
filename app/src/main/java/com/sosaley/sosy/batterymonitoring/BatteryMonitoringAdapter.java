package com.sosaley.sosy.batterymonitoring;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.BatteryMonitoringDTO;
import com.sosaley.sosy.utils.PreferenceUtil;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BatteryMonitoringAdapter extends RecyclerView.Adapter<BatteryMonitoringAdapter.BatteryMonitoringViewHolder> {

    Context context;
    List<BatteryMonitoringDTO> batteryMonitoringDTOList;
    BatteryMonitoringClickedListener batteryMonitoringClickedListener;

    public BatteryMonitoringAdapter(Context context, List<BatteryMonitoringDTO> batteryMonitoringDTOList, BatteryMonitoringClickedListener batteryMonitoringClickedListener) {
        this.context = context;
        this.batteryMonitoringDTOList = batteryMonitoringDTOList;
        this.batteryMonitoringClickedListener = batteryMonitoringClickedListener;
    }

    @NonNull
    @Override
    public BatteryMonitoringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_batterymonitor_adapter, parent, false);

        return new BatteryMonitoringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BatteryMonitoringViewHolder holder, int position) {


        Picasso.with(context).load(batteryMonitoringDTOList.get(position).getBatteryImg()).into(holder.batteryImage);

        String bateryClickStatus = PreferenceUtil.getValueString(context, PreferenceUtil.BATTER_MONITORING_CLICKED_STATUS);
        if (bateryClickStatus != null) {
            if (bateryClickStatus.equals(batteryMonitoringDTOList.get(position).getBatteryId())) {
                holder.batteryName.setBackgroundColor(Color.parseColor("#D3D3D3"));
            } else if (!bateryClickStatus.equals(batteryMonitoringDTOList.get(position).getBatteryId())) {
                holder.batteryName.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }

        holder.batteryName.setText(batteryMonitoringDTOList.get(position).getBatteryName());

    }

    @Override
    public int getItemCount() {
        return batteryMonitoringDTOList == null ? 0 : batteryMonitoringDTOList.size();
    }

    public class BatteryMonitoringViewHolder extends RecyclerView.ViewHolder {

        ImageView batteryImage;
        TextView batteryName;

        public BatteryMonitoringViewHolder(@NonNull View itemView) {
            super(itemView);

            batteryImage = (ImageView) itemView.findViewById(R.id.batteryImg);
            batteryName = (TextView) itemView.findViewById(R.id.batteryName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BatteryMonitoringDTO batteryMonitoringDTO = batteryMonitoringDTOList.get(getAdapterPosition());

                    PreferenceUtil.remove(context, PreferenceUtil.BATTER_MONITORING_CLICKED_STATUS);
                    PreferenceUtil.setValueString(context, PreferenceUtil.BATTER_MONITORING_CLICKED_STATUS, batteryMonitoringDTO.getBatteryId());
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface BatteryMonitoringClickedListener {

        public void batterMonitorClick(BatteryMonitoringDTO batteryMonitoringDTO);

    }

}
