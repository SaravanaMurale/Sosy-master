package com.sosaley.sosy.intruderdetection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sosaley.sosy.R;
import com.sosaley.sosy.lightcontrol.LightControlActivity;
import com.sosaley.sosy.lightcontrol.LightControlAdapter;
import com.sosaley.sosy.model.IntruderControlItemsDTO;
import com.sosaley.sosy.model.IntruderRoomNameDTO;
import com.sosaley.sosy.model.RoomNamesDTO;

import java.util.ArrayList;
import java.util.List;

public class IntruderDetectionActivity extends AppCompatActivity implements IntruderDetectionControlAdapter.IntruderClickListener, IntruderDetectionRoomNameAdapter.IntruderRoomClickListener {

    RecyclerView recyclerView,intruderRoomControlRecyclerView;
    IntruderDetectionControlAdapter intruderDetectionControlAdapter;
    List<IntruderControlItemsDTO> intruderControlItemsDTOList;

    List<IntruderRoomNameDTO> intruderRoomNameDTOList;
    IntruderDetectionRoomNameAdapter intruderDetectionRoomNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intruder_detection);


        getAllIndruderDoorControlImages();
        
        getAllIntruderRoomNames();

    }

    private void getAllIntruderRoomNames() {

        intruderRoomNameDTOList=new ArrayList<>();

        IntruderRoomNameDTO intruderRoomNameDTO1=new IntruderRoomNameDTO("00",getString(R.string.maindoor));
        intruderRoomNameDTOList.add(intruderRoomNameDTO1);

        IntruderRoomNameDTO intruderRoomNameDTO2=new IntruderRoomNameDTO("01",getString(R.string.master_bedroom));
        intruderRoomNameDTOList.add(intruderRoomNameDTO2);

        IntruderRoomNameDTO intruderRoomNameDTO3=new IntruderRoomNameDTO("10",getString(R.string.second_bedroom));
        intruderRoomNameDTOList.add(intruderRoomNameDTO3);

        IntruderRoomNameDTO intruderRoomNameDTO4=new IntruderRoomNameDTO("11",getString(R.string.pooja_room));
        intruderRoomNameDTOList.add(intruderRoomNameDTO4);

        IntruderRoomNameDTO intruderRoomNameDTO5=new IntruderRoomNameDTO("001",getString(R.string.kitchen));
        intruderRoomNameDTOList.add(intruderRoomNameDTO5);

        IntruderRoomNameDTO intruderRoomNameDTO6=new IntruderRoomNameDTO("011",getString(R.string.kitchen));
        intruderRoomNameDTOList.add(intruderRoomNameDTO6);

        initRoomName();

    }

    private void initRoomName() {
        intruderRoomControlRecyclerView=(RecyclerView)findViewById(R.id.intruderRoomControlRecyclerView);
        intruderRoomControlRecyclerView.setHasFixedSize(true);
        intruderRoomControlRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        intruderDetectionRoomNameAdapter = new IntruderDetectionRoomNameAdapter(IntruderDetectionActivity.this, intruderRoomNameDTOList, this);

        intruderRoomControlRecyclerView.setAdapter(intruderDetectionRoomNameAdapter);

    }

    private void getAllIndruderDoorControlImages() {

        intruderControlItemsDTOList = new ArrayList<>();

        int image1 = R.drawable.ceiling;
        int image2 = R.drawable.lamp;
        int image3 = R.drawable.table_light;
        int image4 = R.drawable.desk_light;
        int image5 = R.drawable.ceiling;


        IntruderControlItemsDTO roomNamesDTO1 = new IntruderControlItemsDTO("00", image1, getString(R.string.maindoor), 0);
        intruderControlItemsDTOList.add(roomNamesDTO1);

        IntruderControlItemsDTO roomNamesDTO2 = new IntruderControlItemsDTO("00", image2, getString(R.string.master_bedroom), 0);
        intruderControlItemsDTOList.add(roomNamesDTO2);

        IntruderControlItemsDTO roomNamesDTO3 = new IntruderControlItemsDTO("00", image3, getString(R.string.second_bedroom), 0);
        intruderControlItemsDTOList.add(roomNamesDTO3);

        IntruderControlItemsDTO roomNamesDTO4 = new IntruderControlItemsDTO("00", image4, getString(R.string.pooja_room), 0);
        intruderControlItemsDTOList.add(roomNamesDTO4);

        IntruderControlItemsDTO roomNamesDTO5 = new IntruderControlItemsDTO("00", image5, getString(R.string.kitchen), 0);
        intruderControlItemsDTOList.add(roomNamesDTO5);

        initRecyclerView();


    }

    private void initRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.intruderControlRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        intruderDetectionControlAdapter = new IntruderDetectionControlAdapter(IntruderDetectionActivity.this, intruderControlItemsDTOList, this);

        recyclerView.setAdapter(intruderDetectionControlAdapter);

    }

    @Override
    public void intruderclick(IntruderControlItemsDTO intruderControlItemsDTO) {

    }

    @Override
    public void intruderRoomName(IntruderRoomNameDTO intruderRoomNameDTO) {

    }
}
