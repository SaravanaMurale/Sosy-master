package com.sosaley.sosy.airquality;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.AirQualityDTO;
import com.sosaley.sosy.utils.PreferenceUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AirQualityAdapter extends RecyclerView.Adapter<AirQualityAdapter.AirQualityViewHolder> {

    private Context context;
    private List<AirQualityDTO> airQualityDTOList;
    AirQualityClickedListener airQualityClickedListener;

    public AirQualityAdapter(Context context, List<AirQualityDTO> airQualityDTOList, AirQualityClickedListener airQualityClickedListener) {
        this.context = context;
        this.airQualityDTOList = airQualityDTOList;
        this.airQualityClickedListener = airQualityClickedListener;
    }

    @NonNull
    @Override
    public AirQualityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_airquality_roomadapter, parent, false);

        return new AirQualityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AirQualityViewHolder holder, int position) {

        String airQualityRoomClickStatus = PreferenceUtil.getValueString(context, PreferenceUtil.AIR_QUALITY_CLICKED_STATUS);
        if (airQualityRoomClickStatus != null) {
            if (airQualityRoomClickStatus.equals(airQualityDTOList.get(position).getAirQualityId())) {
                holder.airQualityRoomName.setBackgroundColor(Color.parseColor("#D3D3D3"));
            } else if (!airQualityRoomClickStatus.equals(airQualityDTOList.get(position).getAirQualityId())) {
                holder.airQualityRoomName.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }

        holder.airQualityRoomName.setText(airQualityDTOList.get(position).getAirQualityRoomName());

    }

    @Override
    public int getItemCount() {
        return airQualityDTOList == null ? 0 : airQualityDTOList.size();
    }

    public class AirQualityViewHolder extends RecyclerView.ViewHolder {

        TextView airQualityRoomName;

        public AirQualityViewHolder(@NonNull View itemView) {
            super(itemView);

            airQualityRoomName=(TextView)itemView.findViewById(R.id.airQualityRoomName);

            airQualityRoomName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AirQualityDTO airQualityDTO=airQualityDTOList.get(getAdapterPosition());

                    PreferenceUtil.remove(context, PreferenceUtil.AIR_QUALITY_CLICKED_STATUS);
                    PreferenceUtil.setValueString(context, PreferenceUtil.AIR_QUALITY_CLICKED_STATUS, airQualityDTO.getAirQualityId());
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface AirQualityClickedListener {

        public void airQualityClicked(AirQualityDTO airQualityDTO);

    }

}
