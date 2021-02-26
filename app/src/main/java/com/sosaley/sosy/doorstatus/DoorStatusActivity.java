package com.sosaley.sosy.doorstatus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sosaley.sosy.R;
import com.sosaley.sosy.lightcontrol.LightControlActivity;
import com.sosaley.sosy.lightcontrol.LightControlAdapter;
import com.sosaley.sosy.model.DoorControl;
import com.sosaley.sosy.model.DoorRoomNamesDTO;
import com.sosaley.sosy.model.LightControlItems;
import com.sosaley.sosy.model.RoomNamesDTO;

import java.util.ArrayList;
import java.util.List;

public class DoorStatusActivity extends AppCompatActivity implements DoorStatusAdapter.DoorClickedListener, DoorRoomNameAdapter.DoorRoomClickedListener {

    private RecyclerView doorControlRecyclerview, doorRoomNameRecyclerView;
    private DoorStatusAdapter doorStatusAdapter;
    private List<DoorControl> doorControlList;

    private List<DoorRoomNamesDTO> doorRoomNamesDTOList;
    private DoorRoomNameAdapter doorRoomNameAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door_status);

        getDoorImages();

        getDoorRoomNames();

    }

    private void getDoorRoomNames() {

        doorRoomNamesDTOList = new ArrayList<>();

        DoorRoomNamesDTO roomNamesDTO1 = new DoorRoomNamesDTO("00", getString(R.string.maindoor));
        doorRoomNamesDTOList.add(roomNamesDTO1);

        DoorRoomNamesDTO roomNamesDTO2 = new DoorRoomNamesDTO("01", getString(R.string.master_bedroom));
        doorRoomNamesDTOList.add(roomNamesDTO2);
        DoorRoomNamesDTO roomNamesDTO3 = new DoorRoomNamesDTO("10", getString(R.string.second_bedroom));
        doorRoomNamesDTOList.add(roomNamesDTO3);
        DoorRoomNamesDTO roomNamesDTO4 = new DoorRoomNamesDTO("11", getString(R.string.kitchen));
        doorRoomNamesDTOList.add(roomNamesDTO4);
        DoorRoomNamesDTO roomNamesDTO5 = new DoorRoomNamesDTO("001", getString(R.string.pooja_room));
        doorRoomNamesDTOList.add(roomNamesDTO5);

        initRoomNameView();

    }

    private void initRoomNameView() {

        doorRoomNameRecyclerView = (RecyclerView) findViewById(R.id.doorRoomControlRecyclerView);
        doorRoomNameRecyclerView.setHasFixedSize(true);
        doorRoomNameRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        doorRoomNameAdapter = new DoorRoomNameAdapter(DoorStatusActivity.this, doorRoomNamesDTOList, this);

        doorRoomNameRecyclerView.setAdapter(doorRoomNameAdapter);
    }

    private void getDoorImages() {

        doorControlList = new ArrayList<>();

        int image1 = R.drawable.maindoor;
        int image2 = R.drawable.lamp;
        int image3 = R.drawable.table_light;
        int image4 = R.drawable.desk_light;
        int image5 = R.drawable.ceiling;

        DoorControl doorControl = new DoorControl("00", image1, 0, getString(R.string.maindoor));
        doorControlList.add(doorControl);

        DoorControl doorControl1 = new DoorControl("01", image1, 0, getString(R.string.master_bedroom));
        doorControlList.add(doorControl1);

        DoorControl doorControl2 = new DoorControl("10", image1, 0, getString(R.string.second_bedroom));
        doorControlList.add(doorControl2);

        DoorControl doorControl3 = new DoorControl("11", image1, 0, getString(R.string.pooja_room));
        doorControlList.add(doorControl3);

        DoorControl doorControl4 = new DoorControl("111", image1, 0, getString(R.string.kitchen));
        doorControlList.add(doorControl4);

        initViews();


    }

    private void initViews() {

        doorControlRecyclerview = (RecyclerView) findViewById(R.id.doorControlRecyclerView);
        doorControlRecyclerview.setHasFixedSize(true);
        doorControlRecyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        doorStatusAdapter = new DoorStatusAdapter(DoorStatusActivity.this, doorControlList, this);

        doorControlRecyclerview.setAdapter(doorStatusAdapter);

    }

    @Override
    public void doorClicked(DoorControl doorControl) {

    }

    @Override
    public void doorRoomClicked(DoorRoomNamesDTO doorRoomNamesDTO) {

    }
}
