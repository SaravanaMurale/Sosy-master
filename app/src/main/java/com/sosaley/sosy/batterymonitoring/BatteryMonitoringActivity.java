package com.sosaley.sosy.batterymonitoring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sosaley.sosy.R;
import com.sosaley.sosy.lightcontrol.LightControlActivity;
import com.sosaley.sosy.lightcontrol.RoomControlAdapter;
import com.sosaley.sosy.model.BatteryMonitoringDTO;

import java.util.ArrayList;
import java.util.List;

public class BatteryMonitoringActivity extends AppCompatActivity implements BatteryMonitoringAdapter.BatteryMonitoringClickedListener {

    RecyclerView batteryMonitoringRecyclerView;
    BatteryMonitoringAdapter batteryMonitoringAdapter;
    List<BatteryMonitoringDTO> batteryMonitoringDTOList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_monitoring);


        getBatteryImagesAndName();


        initRecyclerView();
    }

    private void getBatteryImagesAndName() {

        batteryMonitoringDTOList = new ArrayList<>();

        int carBattery = R.drawable.car_battery;
        int bikeBattery = R.drawable.bike_battery;
        int truckBattery = R.drawable.truck_battery;
        int inverterBattery = R.drawable.car_battery;
        int eBikeBattery = R.drawable.bike_battery;
        int eTruckBattery = R.drawable.truck_battery;

        BatteryMonitoringDTO batteryMonitoringDTO1 = new BatteryMonitoringDTO("00", carBattery, getString(R.string.carBattery));
        batteryMonitoringDTOList.add(batteryMonitoringDTO1);

        BatteryMonitoringDTO batteryMonitoringDTO2 = new BatteryMonitoringDTO("01", bikeBattery, getString(R.string.bikeBattery));
        batteryMonitoringDTOList.add(batteryMonitoringDTO2);

        BatteryMonitoringDTO batteryMonitoringDTO3 = new BatteryMonitoringDTO("10", truckBattery, getString(R.string.truckBattery));
        batteryMonitoringDTOList.add(batteryMonitoringDTO3);

        BatteryMonitoringDTO batteryMonitoringDTO4 = new BatteryMonitoringDTO("11", inverterBattery, getString(R.string.inverterBattery));
        batteryMonitoringDTOList.add(batteryMonitoringDTO4);

        BatteryMonitoringDTO batteryMonitoringDTO5 = new BatteryMonitoringDTO("000", eBikeBattery, getString(R.string.eBikeBattery));
        batteryMonitoringDTOList.add(batteryMonitoringDTO5);

        BatteryMonitoringDTO batteryMonitoringDTO6 = new BatteryMonitoringDTO("001", eTruckBattery, getString(R.string.eTruckBattery));
        batteryMonitoringDTOList.add(batteryMonitoringDTO6);


    }

    private void initRecyclerView() {

        batteryMonitoringRecyclerView = (RecyclerView) findViewById(R.id.batteryMonitoringRecyclerView);
        batteryMonitoringRecyclerView.setHasFixedSize(true);
        batteryMonitoringRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        batteryMonitoringAdapter = new BatteryMonitoringAdapter(BatteryMonitoringActivity.this, batteryMonitoringDTOList, this);

        batteryMonitoringRecyclerView.setAdapter(batteryMonitoringAdapter);


    }

    @Override
    public void batterMonitorClick(BatteryMonitoringDTO batteryMonitoringDTO) {

    }
}
