package com.sosaley.sosy.homescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sosaley.sosy.R;
import com.sosaley.sosy.airquality.AirQualityActivity;
import com.sosaley.sosy.batterymonitoring.BatteryMonitoringActivity;
import com.sosaley.sosy.doorstatus.DoorStatusActivity;
import com.sosaley.sosy.intruderdetection.IntruderDetectionActivity;
import com.sosaley.sosy.lightcontrol.LightControlActivity;
import com.sosaley.sosy.model.HomeItemResponse;
import com.sosaley.sosy.roomtemperature.RoomTemperatureActivity;
import com.sosaley.sosy.utils.PreferenceUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HomeFragment extends Fragment implements HomeAdapter.HomeItemClickListener {


    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    List<HomeItemResponse> homeItemResponseList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        getHomeIcons();

        initRecyclerView(view);


        return view;
    }

    private void getHomeIcons() {

        homeItemResponseList = new ArrayList<>();

        int homeLight=R.drawable.main_lightbulb;
        int homeDoorStatus=R.drawable.main_door_open;
        int homeIntruderDetec=R.drawable.main_exit;
        int homeBattery=R.drawable.main_car;
        int homeAir=R.drawable.main_air_quality;
        int homeTemp=R.drawable.main_room;
        int homeStove=R.drawable.main_stove;

        HomeItemResponse homeScreenDTO=new HomeItemResponse("LightControl_01",homeLight,getString(R.string.lightcontrol));
        homeItemResponseList.add(homeScreenDTO);

        HomeItemResponse homeScreenDTO1=new HomeItemResponse("DoorStatus_02",homeDoorStatus,getString(R.string.doorstatus));
        homeItemResponseList.add(homeScreenDTO1);

        HomeItemResponse homeScreenDTO2=new HomeItemResponse("IntruderDetection_03",homeIntruderDetec,getString(R.string.intruderdetection));
        homeItemResponseList.add(homeScreenDTO2);

        HomeItemResponse homeScreenDTO3=new HomeItemResponse("BatteryMonitoring_04",homeBattery,getString(R.string.batterymonitoring));
        homeItemResponseList.add(homeScreenDTO3);

        HomeItemResponse homeScreenDTO4=new HomeItemResponse("AirQuality_05",homeAir,getString(R.string.airquality_));
        homeItemResponseList.add(homeScreenDTO4);

        HomeItemResponse homeScreenDTO5=new HomeItemResponse("RoomTemp_06",homeTemp,getString(R.string.room_temperatur));
        homeItemResponseList.add(homeScreenDTO5);

        HomeItemResponse homeScreenDTO6=new HomeItemResponse("Stove_07",homeStove,getString(R.string.stove));
        homeItemResponseList.add(homeScreenDTO6);



    }

    private void initRecyclerView(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.homeRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        homeAdapter = new HomeAdapter(getActivity(), homeItemResponseList, this);

        recyclerView.setAdapter(homeAdapter);

    }

    @Override
    public void homeItemClick(HomeItemResponse homeItemResponse) {

        Intent launchIntent=null;

        if(homeItemResponse.getHomeItemId().equals("LightControl_01")){
            launchIntent=new Intent(getActivity(),LightControlActivity.class);
        }else if(homeItemResponse.getHomeItemId().equals("DoorStatus_02")){
            launchIntent=new Intent(getActivity(),DoorStatusActivity.class);
        }else if(homeItemResponse.getHomeItemId().equals("IntruderDetection_03")){
            launchIntent=new Intent(getActivity(),IntruderDetectionActivity.class);
        }else if(homeItemResponse.getHomeItemId().equals("BatteryMonitoring_04")){
            launchIntent=new Intent(getActivity(),BatteryMonitoringActivity.class);
        }else if(homeItemResponse.getHomeItemId().equals("AirQuality_05")){
            launchIntent=new Intent(getActivity(),AirQualityActivity.class);
        }else if(homeItemResponse.getHomeItemId().equals("RoomTemp_06")){
            launchIntent=new Intent(getActivity(),RoomTemperatureActivity.class);
        }else if(homeItemResponse.getHomeItemId().equals("Stove_07")){
            launchIntent=new Intent(getActivity(),LightControlActivity.class);
        }

        startActivity(launchIntent);
        PreferenceUtil.setValueString(getActivity(), PreferenceUtil.HOME_ITEM_ID, homeItemResponse.getHomeItemId());
        //launchActivity();


    }

    /*private void launchActivity() {
        Intent intent = new Intent(getActivity(), LightControlActivity.class);
        startActivity(intent);
    }*/
}
