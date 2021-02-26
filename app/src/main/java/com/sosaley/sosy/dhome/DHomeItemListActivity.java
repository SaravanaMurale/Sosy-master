package com.sosaley.sosy.dhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sosaley.sosy.R;

public class DHomeItemListActivity extends AppCompatActivity {

    Button startD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_home_item_list);

        startD=(Button)findViewById(R.id.startD);

        startD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(DHomeItemListActivity.this,LocationFetchTurnOFFLightActivity.class);
                startActivity(intent);

            }
        });
    }
}