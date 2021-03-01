package com.sosaley.sosy.dhome;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sosaley.sosy.R;
import com.sosaley.sosy.dhome.dutils.PermissionUtils;

import static com.sosaley.sosy.dhome.dutils.AppConstants.LOCATION_PERMISSION_REQUEST_CODE;

public class DLoginActivity extends AppCompatActivity {

    private EditText loginUserName, loginPassword;
    private Button btnLogin;
    private TextView signUp, btn_Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_login);

        initView();

    }

    private void initView() {

        loginUserName = (EditText) findViewById(R.id.login_email);
        loginPassword = (EditText) findViewById(R.id.login_password);
        signUp = (TextView) findViewById(R.id.signUp);
        btn_Reset = (TextView) findViewById(R.id.btn_Reset);

        btnLogin = (Button) findViewById(R.id.loginBtn);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                checkLocationPermission();


            }
        });

    }

    private void checkLocationPermission() {


        if (!PermissionUtils.hasPermission(DLoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                && !PermissionUtils.hasPermission(DLoginActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            PermissionUtils.requestPermissions(DLoginActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);


        } else {

            if (PermissionUtils.hasPermission(DLoginActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                    && PermissionUtils.hasPermission(DLoginActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

                //If permission is granted turn on gps


                Intent intent = new Intent(DLoginActivity.this, SignupActivity.class);
                startActivity(intent);



            }

        }


    }
}