package com.sosaley.sosy.intruderdetection;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.IntruderRoomNameDTO;
import com.sosaley.sosy.utils.PreferenceUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IntruderDetectionRoomNameAdapter extends RecyclerView.Adapter<IntruderDetectionRoomNameAdapter.IntruderRoomNameViewHolder> {

    private Context context;
    List<IntruderRoomNameDTO> intruderRoomNameDTOList;
    IntruderRoomClickListener intruderRoomClickListener;

    public IntruderDetectionRoomNameAdapter(Context context, List<IntruderRoomNameDTO> intruderRoomNameDTOList, IntruderRoomClickListener intruderRoomClickListener) {
        this.context = context;
        this.intruderRoomNameDTOList = intruderRoomNameDTOList;
        this.intruderRoomClickListener = intruderRoomClickListener;
    }

    @NonNull
    @Override
    public IntruderRoomNameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_intruder_detection_name_adapter, parent, false);

        return new IntruderRoomNameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntruderRoomNameViewHolder holder, int position) {

        String intruderRoomClickedStatus = PreferenceUtil.getValueString(context, PreferenceUtil.INTRUDER_ROOM_CLICKED_STATUS);

        if (intruderRoomClickedStatus != null) {
            if (intruderRoomClickedStatus.equals(intruderRoomNameDTOList.get(position).getIntruderRoomId())) {
                holder.intruderDoorRoomName.setBackgroundColor(Color.parseColor("#D3D3D3"));
            } else if (!intruderRoomClickedStatus.equals(intruderRoomNameDTOList.get(position).getIntruderRoomId())) {
                holder.intruderDoorRoomName.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }

        holder.intruderDoorRoomName.setText(intruderRoomNameDTOList.get(position).getIntruderRoomName());


    }

    @Override
    public int getItemCount() {
        return intruderRoomNameDTOList == null ? 0 : intruderRoomNameDTOList.size();
    }

    public class IntruderRoomNameViewHolder extends RecyclerView.ViewHolder {

        TextView intruderDoorRoomName;

        public IntruderRoomNameViewHolder(@NonNull View itemView) {
            super(itemView);

            intruderDoorRoomName = (TextView) itemView.findViewById(R.id.intruderDoorRoomName);

            intruderDoorRoomName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    IntruderRoomNameDTO intruderRoomNameDTO = intruderRoomNameDTOList.get(getAdapterPosition());

                    PreferenceUtil.remove(context, PreferenceUtil.INTRUDER_ROOM_CLICKED_STATUS);
                    PreferenceUtil.setValueString(context, PreferenceUtil.INTRUDER_ROOM_CLICKED_STATUS, intruderRoomNameDTO.getIntruderRoomId());
                    notifyDataSetChanged();
                }
            });

        }
    }

    public interface IntruderRoomClickListener {

        public void intruderRoomName(IntruderRoomNameDTO intruderRoomNameDTO);
    }

}
