package com.sosaley.sosy.doorstatus;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.DoorRoomNamesDTO;
import com.sosaley.sosy.utils.PreferenceUtil;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DoorRoomNameAdapter extends RecyclerView.Adapter<DoorRoomNameAdapter.DoorRoomViewHolder> {

    Context context;
    List<DoorRoomNamesDTO> doorRoomNamesDTOList;
    DoorRoomClickedListener doorRoomClickedListener;

    public DoorRoomNameAdapter(Context context, List<DoorRoomNamesDTO> doorRoomNamesDTOList, DoorRoomClickedListener doorRoomClickedListener) {
        this.context = context;
        this.doorRoomNamesDTOList = doorRoomNamesDTOList;
        this.doorRoomClickedListener = doorRoomClickedListener;
    }

    @NonNull
    @Override
    public DoorRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.layout_doorroom_name_adapter, parent, false);

        return new DoorRoomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DoorRoomViewHolder holder, int position) {

        String doorRoomClickStatus = PreferenceUtil.getValueString(context, PreferenceUtil.DOOR_ROOM_CLICKED_STATUS);

        if (doorRoomClickStatus != null) {
            if (doorRoomClickStatus.equals(doorRoomNamesDTOList.get(position).getDoorRoomId())) {
                holder.doorRoomName.setBackgroundColor(Color.parseColor("#D3D3D3"));
            } else if (!doorRoomClickStatus.equals(doorRoomNamesDTOList.get(position).getDoorRoomId())) {
                holder.doorRoomName.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        }

        holder.doorRoomName.setText(doorRoomNamesDTOList.get(position).getDoorRoomName());

    }

    @Override
    public int getItemCount() {
        return doorRoomNamesDTOList == null ? 0 : doorRoomNamesDTOList.size();
    }


    public class DoorRoomViewHolder extends RecyclerView.ViewHolder {

        public TextView doorRoomName;

        public DoorRoomViewHolder(@NonNull View itemView) {
            super(itemView);

            doorRoomName = (TextView) itemView.findViewById(R.id.doorRoomName);

            doorRoomName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DoorRoomNamesDTO doorRoomNamesDTO = doorRoomNamesDTOList.get(getAdapterPosition());

                    PreferenceUtil.remove(context, PreferenceUtil.DOOR_ROOM_CLICKED_STATUS);
                    PreferenceUtil.setValueString(context, PreferenceUtil.DOOR_ROOM_CLICKED_STATUS, doorRoomNamesDTO.getDoorRoomId());
                    notifyDataSetChanged();

                }
            });
        }
    }

    public interface DoorRoomClickedListener {
        public void doorRoomClicked(DoorRoomNamesDTO doorRoomNamesDTO);
    }
}
