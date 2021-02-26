package com.sosaley.sosy.doorstatus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.DoorControl;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DoorStatusAdapter extends RecyclerView.Adapter<DoorStatusAdapter.DoorStatusViewHolder> {

    private Context context;
    List<DoorControl> doorControlList;
    DoorClickedListener doorClickedListener;

    public DoorStatusAdapter(Context context, List<DoorControl> doorControlList, DoorClickedListener doorClickedListener) {
        this.context = context;
        this.doorControlList = doorControlList;
        this.doorClickedListener = doorClickedListener;
    }

    @NonNull
    @Override
    public DoorStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.layout_doorcontroladapter, parent, false);

        return new DoorStatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoorStatusViewHolder holder, int position) {

        Picasso.with(context).load(doorControlList.get(position).getDoorImage()).into(holder.doorImage);
        holder.doorName.setText(doorControlList.get(position).getDoorName());

        if(doorControlList.get(position).getDoorCount()>0){
            holder.decDoor.setEnabled(true);
            holder.doorCount.setText(""+doorControlList.get(position).getDoorCount());
        } else if(doorControlList.get(position).getDoorCount()==0){
            holder.decDoor.setEnabled(false);
            holder.doorCount.setText(""+doorControlList.get(position).getDoorCount());
        }


    }

    @Override
    public int getItemCount() {
        return doorControlList == null ? 0 : doorControlList.size();
    }

    public class DoorStatusViewHolder extends RecyclerView.ViewHolder {
       private ImageView doorImage;
       private TextView incDoor, decDoor, doorCount, doorName;


        public DoorStatusViewHolder(@NonNull View itemView) {
            super(itemView);

            doorImage = (ImageView) itemView.findViewById(R.id.doorImg);
            doorName = (TextView) itemView.findViewById(R.id.doorName);
            incDoor = (TextView) itemView.findViewById(R.id.incDoor);
            decDoor = (TextView) itemView.findViewById(R.id.decDoor);
            doorCount = (TextView) itemView.findViewById(R.id.doorCount);

            incDoor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DoorControl doorControl=doorControlList.get(getAdapterPosition());
                    doorControl.setDoorCount(doorControl.getDoorCount()+1);
                    notifyDataSetChanged();

                }
            });

            decDoor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DoorControl doorControl=doorControlList.get(getAdapterPosition());

                   doorControl.setDoorCount(doorControl.getDoorCount()-1);

                   if(doorControl.getDoorCount()>0){
                       notifyDataSetChanged();
                   }else if(doorControl.getDoorCount()==0){
                       notifyDataSetChanged();
                   }

                }
            });

        }
    }

    interface DoorClickedListener {

        public void doorClicked(DoorControl doorControl);
    }
}
