package com.sosaley.sosy.lightcontrol;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.RoomNamesDTO;
import com.sosaley.sosy.utils.PreferenceUtil;


import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RoomControlAdapter extends RecyclerView.Adapter<RoomControlAdapter.RoomControlViewHolder> {

    Context context;
    List<RoomNamesDTO> roomNamesDTOList;
    RoomNameClickedListener roomNameClickedListener;


    public RoomControlAdapter(Context context, List<RoomNamesDTO> roomNamesDTOList, RoomNameClickedListener roomNameClickedListener) {
        this.context = context;
        this.roomNamesDTOList = roomNamesDTOList;
        this.roomNameClickedListener = roomNameClickedListener;
    }

    @NonNull
    @Override
    public RoomControlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_roomname_adapter, parent, false);

        return new RoomControlViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RoomControlViewHolder holder, int position) {


        String roomClickStatus = PreferenceUtil.getValueString(context, PreferenceUtil.ROOM_CLICKED_STATUS);
        if (roomClickStatus != null) {
            if (roomClickStatus.equals(roomNamesDTOList.get(position).getRoomId())) {
                holder.roomName.setBackgroundColor(Color.parseColor("#D3D3D3"));
            } else if (!roomClickStatus.equals(roomNamesDTOList.get(position).getRoomId())) {
                holder.roomName.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }

        holder.roomName.setText(roomNamesDTOList.get(position).getRoomName());


    }

    @Override
    public int getItemCount() {
        return roomNamesDTOList == null ? 0 : roomNamesDTOList.size();
    }

    class RoomControlViewHolder extends RecyclerView.ViewHolder {

        TextView roomName;

        public RoomControlViewHolder(@NonNull View itemView) {
            super(itemView);

            roomName = (TextView) itemView.findViewById(R.id.roomName);

            roomName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    RoomNamesDTO roomNamesDTO = roomNamesDTOList.get(getAdapterPosition());

                    PreferenceUtil.remove(context, PreferenceUtil.ROOM_CLICKED_STATUS);
                    PreferenceUtil.setValueString(context, PreferenceUtil.ROOM_CLICKED_STATUS, roomNamesDTO.getRoomId());
                    notifyDataSetChanged();


                }
            });

        }
    }

    interface RoomNameClickedListener {

        public void roomNameClicked(RoomNamesDTO roomNamesDTO);

    }

}
