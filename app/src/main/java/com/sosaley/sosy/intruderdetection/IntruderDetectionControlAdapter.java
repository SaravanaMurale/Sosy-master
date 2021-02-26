package com.sosaley.sosy.intruderdetection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.IntruderControlItemsDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class IntruderDetectionControlAdapter extends RecyclerView.Adapter<IntruderDetectionControlAdapter.IntruderDetectionViewHolder> {

    private Context context;
    List<IntruderControlItemsDTO> intruderControlItemsDTOList;
    IntruderClickListener intruderClickListener;

    public IntruderDetectionControlAdapter(Context context, List<IntruderControlItemsDTO> intruderControlItemsDTOList, IntruderClickListener intruderClickListener) {
        this.context = context;
        this.intruderControlItemsDTOList = intruderControlItemsDTOList;
        this.intruderClickListener = intruderClickListener;
    }

    @NonNull
    @Override
    public IntruderDetectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_intruder_detection_adapter, parent, false);

        return new IntruderDetectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IntruderDetectionViewHolder holder, int position) {

        Picasso.with(context).load(intruderControlItemsDTOList.get(position).getIntruderDetecImg()).into(holder.intruImage);
        holder.intruDoorName.setText(intruderControlItemsDTOList.get(position).getIntruderDetecName());

        if (intruderControlItemsDTOList.get(position).getIntruderDetcCount() > 0) {
            holder.intruDoorDec.setEnabled(true);
            holder.intruDoorCount.setText("" + intruderControlItemsDTOList.get(position).getIntruderDetcCount());
        } else if (intruderControlItemsDTOList.get(position).getIntruderDetcCount() == 0) {
            holder.intruDoorDec.setEnabled(false);
            holder.intruDoorCount.setText("" + intruderControlItemsDTOList.get(position).getIntruderDetcCount());
        }


    }

    @Override
    public int getItemCount() {
        return intruderControlItemsDTOList == null ? 0 : intruderControlItemsDTOList.size();
    }

    public class IntruderDetectionViewHolder extends RecyclerView.ViewHolder {

        ImageView intruImage;
        TextView intruDoorInc, intruDoorDec, intruDoorCount, intruDoorName;


        public IntruderDetectionViewHolder(@NonNull View itemView) {
            super(itemView);

            intruImage = (ImageView) itemView.findViewById(R.id.intruDoorImg);
            intruDoorName = (TextView) itemView.findViewById(R.id.intruDoortName);
            intruDoorInc = (TextView) itemView.findViewById(R.id.intruInc);
            intruDoorDec = (TextView) itemView.findViewById(R.id.intruDec);
            intruDoorCount = (TextView) itemView.findViewById(R.id.intruDoorCount);

            intruDoorInc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    IntruderControlItemsDTO intruderControlItemsDTO = intruderControlItemsDTOList.get(getAdapterPosition());

                    intruderControlItemsDTO.setIntruderDetcCount(intruderControlItemsDTO.getIntruderDetcCount() + 1);
                    notifyDataSetChanged();

                }
            });

            intruDoorDec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    IntruderControlItemsDTO intruderControlItemsDTO = intruderControlItemsDTOList.get(getAdapterPosition());

                    intruderControlItemsDTO.setIntruderDetcCount(intruderControlItemsDTO.getIntruderDetcCount() - 1);

                    if (intruderControlItemsDTO.getIntruderDetcCount() > 0) {
                        notifyDataSetChanged();
                    } else if (intruderControlItemsDTO.getIntruderDetcCount() == 0) {
                        notifyDataSetChanged();
                    }

                }
            });

        }
    }

    public interface IntruderClickListener {

        public void intruderclick(IntruderControlItemsDTO intruderControlItemsDTO);
    }

}
