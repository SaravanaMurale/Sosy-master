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
import android.widget.Toast;

import com.sosaley.sosy.R;
import com.sosaley.sosy.dhome.dutils.PermissionUtils;
import com.sosaley.sosy.dhome.dutils.Validation;

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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = loginUserName.getText().toString().trim();
                String password = loginPassword.getText().toString().trim();

                if (!Validation.validateEmptyString(mobile)) {

                    Toast.makeText(DLoginActivity.this, "Please Enter Mobile Number", Toast.LENGTH_LONG).show();
                    return;

                }

                if (!Validation.validateEmptyString(password)) {

                    Toast.makeText(DLoginActivity.this, "Please Enter Password", Toast.LENGTH_LONG).show();
                    return;

                }

                if(!Validation.validateMobileNumber(mobile)){
                    Toast.makeText(DLoginActivity.this, "Please Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
                    loginUserName.findFocus();
                    return;
                }

                if(!Validation.validatePassword(password)){
                    Toast.makeText(DLoginActivity.this, "Password should have minimum 6 characters", Toast.LENGTH_LONG).show();
                    loginPassword.findFocus();
                    return;
                }


                if(Validation.validateMobileNumber(mobile) && Validation.validatePassword(password)){
                    //Validate mobile number and password in firestore
                }


            }
        });


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