package com.sosaley.sosy.roomtemperature;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.RoomTempDTO;
import com.sosaley.sosy.utils.PreferenceUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoomTempAdapter extends RecyclerView.Adapter<RoomTempAdapter.RoomTempViewHolder> {

    private Context context;
    private List<RoomTempDTO> roomTempDTOList;
    private RoomTempClickListener roomTempClickListener;

    public RoomTempAdapter(Context context, List<RoomTempDTO> roomTempDTOList, RoomTempClickListener roomTempClickListener) {
        this.context = context;
        this.roomTempDTOList = roomTempDTOList;
        this.roomTempClickListener = roomTempClickListener;
    }

    @NonNull
    @Override
    public RoomTempViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.layout_roomtemp_roomname,parent,false);

        return new RoomTempViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomTempViewHolder holder, int position) {

        String roomTempClickStatus = PreferenceUtil.getValueString(context, PreferenceUtil.ROOM_TEMP_CLICKED_STATUS);

        if (roomTempClickStatus != null) {
            if (roomTempClickStatus.equals(roomTempDTOList.get(position).getRoomTempId())) {
                holder.roomTempRoomName.setBackgroundColor(Color.parseColor("#D3D3D3"));
            } else if (!roomTempClickStatus.equals(roomTempDTOList.get(position).getRoomTempId())) {
                holder.roomTempRoomName.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }

        holder.roomTempRoomName.setText(roomTempDTOList.get(position).getRoomTempRoomName());

    }

    @Override
    public int getItemCount() {
        return roomTempDTOList==null?0:roomTempDTOList.size();
    }

    public class RoomTempViewHolder extends RecyclerView.ViewHolder{

        TextView roomTempRoomName;

        public RoomTempViewHolder(@NonNull View itemView) {
            super(itemView);

            roomTempRoomName=(TextView)itemView.findViewById(R.id.roomTempRoomName);

            roomTempRoomName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    RoomTempDTO roomTempDTO=roomTempDTOList.get(getAdapterPosition());

                    PreferenceUtil.remove(context, PreferenceUtil.ROOM_TEMP_CLICKED_STATUS);
                    PreferenceUtil.setValueString(context, PreferenceUtil.ROOM_TEMP_CLICKED_STATUS, roomTempDTO.getRoomTempId());
                    notifyDataSetChanged();

                }
            });

        }
    }

    public interface RoomTempClickListener{

        public void roomTempClick(RoomTempDTO roomTempDTO);

    }

}
