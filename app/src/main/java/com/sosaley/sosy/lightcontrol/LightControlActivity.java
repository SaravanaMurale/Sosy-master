package com.sosaley.sosy.lightcontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.sosaley.sosy.R;
import com.sosaley.sosy.model.LightControlItems;
import com.sosaley.sosy.model.RoomNamesDTO;

import java.util.ArrayList;
import java.util.List;

public class LightControlActivity extends AppCompatActivity implements LightControlAdapter.LightControlItelClickListener, RoomControlAdapter.RoomNameClickedListener {

    RecyclerView recyclerView, roomNameRecyclerView;
    LightControlAdapter lightControlAdapter;
    RoomControlAdapter roomControlAdapter;

    List<LightControlItems> lightControlItemsList;
    List<RoomNamesDTO> roomNamesDTOList;
    Button lightControlConfigure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_control);

        getAllLightImages();

        getAllRoomNages();


    }

    private void getAllRoomNages() {

        roomNamesDTOList = new ArrayList<>();

        RoomNamesDTO roomNamesDTO1 = new RoomNamesDTO("00", getString(R.string.hall));
        roomNamesDTOList.add(roomNamesDTO1);

        RoomNamesDTO roomNamesDTO2 = new RoomNamesDTO("01", getString(R.string.master_bedroom));
        roomNamesDTOList.add(roomNamesDTO2);

        RoomNamesDTO roomNamesDTO3 = new RoomNamesDTO("10", getString(R.string.second_bedroom));
        roomNamesDTOList.add(roomNamesDTO3);

        RoomNamesDTO roomNamesDTO4 = new RoomNamesDTO("11", getString(R.string.pooja_room));
        roomNamesDTOList.add(roomNamesDTO4);

        RoomNamesDTO roomNamesDTO5 = new RoomNamesDTO("001", getString(R.string.kitchen));
        roomNamesDTOList.add(roomNamesDTO5);

        initRoomView();

    }


    private void getAllLightImages() {

        lightControlItemsList = new ArrayList<>();

        int image1 = R.drawable.ceiling;
        int image2 = R.drawable.lamp;
        int image3 = R.drawable.table_light;
        int image4 = R.drawable.desk_light;
        int image5 = R.drawable.ceiling;
        LightControlItems lightControlItems1 = new LightControlItems("00", image1, getString(R.string.celeing_light), 0);

        lightControlItemsList.add(lightControlItems1);
        LightControlItems lightControlItems2 = new LightControlItems("01", image2, getString(R.string.table_light), 0);
        lightControlItemsList.add(lightControlItems2);
        LightControlItems lightControlItems3 = new LightControlItems("10", image3, getString(R.string.dim_light), 0);
        lightControlItemsList.add(lightControlItems3);
        LightControlItems lightControlItems4 = new LightControlItems("11", image4, getString(R.string.reading_light), 0);
        lightControlItemsList.add(lightControlItems4);
        LightControlItems lightControlItems5 = new LightControlItems("001", image5, getString(R.string.single_light), 0);
        lightControlItemsList.add(lightControlItems5);


        initView();

    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.lightControlRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        lightControlAdapter = new LightControlAdapter(LightControlActivity.this, lightControlItemsList, this);

        recyclerView.setAdapter(lightControlAdapter);
        //lightControlAdapter.setData(lightControlItemsImages);


    }


    private void initRoomView() {

        roomNameRecyclerView = (RecyclerView) findViewById(R.id.roomControlRecyclerView);
        roomNameRecyclerView.setHasFixedSize(true);
        roomNameRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        roomControlAdapter = new RoomControlAdapter(LightControlActivity.this, roomNamesDTOList, this);

        roomNameRecyclerView.setAdapter(roomControlAdapter);

    }


    @Override
    public void lightControlItemClicked(LightControlItems lightControlItems) {

    }

    @Override
    public void roomNameClicked(RoomNamesDTO roomNamesDTO) {

    }
}
