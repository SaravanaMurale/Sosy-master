package com.sosaley.sosy.airquality;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sosaley.sosy.R;
import com.sosaley.sosy.lightcontrol.LightControlActivity;
import com.sosaley.sosy.lightcontrol.RoomControlAdapter;
import com.sosaley.sosy.model.AirQualityDTO;

import java.util.ArrayList;
import java.util.List;

public class AirQualityActivity extends AppCompatActivity implements AirQualityAdapter.AirQualityClickedListener {

    RecyclerView airQualityRecyclerView;
    AirQualityAdapter airQualityAdapter;
    List<AirQualityDTO> airQualityDTOList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_quality);

        getAirQualityRoomNames();
    }

    private void getAirQualityRoomNames() {

        airQualityDTOList=new ArrayList<>();

        AirQualityDTO airQualityDTO1=new AirQualityDTO("00",getString(R.string.hall));
        airQualityDTOList.add(airQualityDTO1);

        AirQualityDTO airQualityDTO2=new AirQualityDTO("01",getString(R.string.master_bedroom));
        airQualityDTOList.add(airQualityDTO2);

        AirQualityDTO airQualityDTO3=new AirQualityDTO("10",getString(R.string.second_bedroom));
        airQualityDTOList.add(airQualityDTO3);

        AirQualityDTO airQualityDT4=new AirQualityDTO("11",getString(R.string.pooja_room));
        airQualityDTOList.add(airQualityDT4);

        AirQualityDTO airQualityDTO5=new AirQualityDTO("001",getString(R.string.kitchen));
        airQualityDTOList.add(airQualityDTO5);

        initRecyclerView();

    }

    private void initRecyclerView() {

        airQualityRecyclerView=(RecyclerView)findViewById(R.id.airQuaRecyclerView);

        airQualityRecyclerView.setHasFixedSize(true);
        airQualityRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        airQualityAdapter = new AirQualityAdapter(AirQualityActivity.this,airQualityDTOList,this);

        airQualityRecyclerView.setAdapter(airQualityAdapter);



    }

    @Override
    public void airQualityClicked(AirQualityDTO airQualityDTO) {

    }
}
