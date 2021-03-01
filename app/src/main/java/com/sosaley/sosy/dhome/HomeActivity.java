package com.sosaley.sosy.dhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sosaley.sosy.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeClickable {

    RecyclerView dHomeRecyclerView;
    HomeAdapter homeAdapter;
    List<HomeResponse> homeResponseList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dHomeRecyclerView=(RecyclerView)findViewById(R.id.d_home_item_recyclerview);
        dHomeRecyclerView.setHasFixedSize(true);
        dHomeRecyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this));

        homeResponseList=new ArrayList<>();

        homeAdapter=new HomeAdapter(this,homeResponseList,this);

        getHomeDataFromFireStore();

    }

    private void getHomeDataFromFireStore() {



    }


    @Override
    public void onHomeClick(HomeResponse homeResponse) {

    }
}