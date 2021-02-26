package com.sosaley.sosy.roomtemperature;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sosaley.sosy.R;
import com.sosaley.sosy.airquality.AirQualityActivity;
import com.sosaley.sosy.airquality.AirQualityAdapter;
import com.sosaley.sosy.model.AirQualityDTO;
import com.sosaley.sosy.model.RoomTempDTO;

import java.util.ArrayList;
import java.util.List;

public class RoomTemperatureActivity extends AppCompatActivity implements RoomTempAdapter.RoomTempClickListener {

    RecyclerView roomTempRecyclerView;
    RoomTempAdapter roomTempAdapter;
    List<RoomTempDTO> roomTempDTOList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_temperature);


        getRoomTemperatureRoomName();

    }

    private void getRoomTemperatureRoomName() {

        roomTempDTOList=new ArrayList<>();

        RoomTempDTO roomTempDTO1=new RoomTempDTO("00",getString(R.string.hall));
        roomTempDTOList.add(roomTempDTO1);

        RoomTempDTO roomTempDTO2=new RoomTempDTO("01",getString(R.string.master_bedroom));
        roomTempDTOList.add(roomTempDTO2);

        RoomTempDTO roomTempDTO3=new RoomTempDTO("10",getString(R.string.second_bedroom));
        roomTempDTOList.add(roomTempDTO3);

        RoomTempDTO roomTempDTO4=new RoomTempDTO("11",getString(R.string.pooja_room));
        roomTempDTOList.add(roomTempDTO4);

        RoomTempDTO roomTempDTO5=new RoomTempDTO("001",getString(R.string.kitchen));
        roomTempDTOList.add(roomTempDTO5);

        RoomTempDTO roomTempDTO6=new RoomTempDTO("011",getString(R.string.master_bedroom));
        roomTempDTOList.add(roomTempDTO6);

        initRecyclerView();

    }

    private void initRecyclerView() {

        roomTempRecyclerView=(RecyclerView)findViewById(R.id.roomTempRecyclerView);

        roomTempRecyclerView.setHasFixedSize(true);
        roomTempRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        roomTempAdapter = new RoomTempAdapter(RoomTemperatureActivity.this,roomTempDTOList,this);

        roomTempRecyclerView.setAdapter(roomTempAdapter);


    }

    @Override
    public void roomTempClick(RoomTempDTO roomTempDTO) {

    }
}
