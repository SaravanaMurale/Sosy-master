package com.sosaley.sosy.dhome;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sosaley.sosy.R;
import com.sosaley.sosy.dhome.dutils.AppConstants;
import com.sosaley.sosy.dhome.dutils.GpsUtils;
import com.sosaley.sosy.dhome.dutils.LocationJobIntentService;
import com.sosaley.sosy.dhome.dutils.Validation;

import static com.sosaley.sosy.dhome.dutils.AppConstants.GPS_PROVIDER_CODE;
import static com.sosaley.sosy.dhome.dutils.Validation.validateEmail;
import static com.sosaley.sosy.dhome.dutils.Validation.validateMobileNumber;
import static com.sosaley.sosy.dhome.dutils.Validation.validatePassword;

public class SignupActivity extends AppCompatActivity {

    private boolean gpsEnabledStatus;
    public boolean isGPS;

    private Button btnSignUp;
    private EditText signUpName, signUpEmail, signUpMobile, signUpPassword, signUpCPassword;

    Double dStLocLat,dStLocLong;

    TextView dAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initView();

        initEnableGPS();




        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = signUpName.getText().toString().trim();
                String userEmail = signUpEmail.getText().toString().trim();
                String userMobile = signUpMobile.getText().toString().trim();
                String userPassword = signUpPassword.getText().toString().trim();
                String userCPassword = signUpCPassword.getText().toString().trim();


                validateSignupRequest(userName,userEmail,userMobile,userPassword,userCPassword);

                if (Validation.validateName(userName) && validateEmail(userEmail) && validateMobileNumber(userMobile) && validatePassword(userPassword) && validatePassword(userCPassword) && userPassword.equals(userCPassword) && dStLocLat!=null && dStLocLong!=null) {
                    //save store details and its location in firestore

                }




            }
        });
    }

    private void initEnableGPS() {

        gpsEnabledStatus=new GpsUtils(SignupActivity.this).gpsStatus();

        if (gpsEnabledStatus) {

            //             getDeviceLocation();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getDeviceLocation();
                }
            }, 5000);
        } else if (!gpsEnabledStatus) {

            enableGPS();
        }

    }

    @Override
    public void
    onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == GPS_PROVIDER_CODE) {

                isGPS = true;


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getDeviceLocation();
                    }
                }, 5000);


            }

        } else {

        }
    }



    private void enableGPS() {

        new GpsUtils(SignupActivity.this).turnGPSOn(new GpsUtils.onGpsListener() {
            @Override
            public void gpsStatus(boolean isGPSEnable) {
                // turn on GPS*

                isGPS = isGPSEnable;

                System.out.println("ISGPS" + isGPS);

            }
        });

    }

    @SuppressLint("MissingPermission")
    private void getDeviceLocation() {

        //System.out.println("GetDeviceLocationIsCalled");

        MyResultReceiver myResultReceiver = new MyResultReceiver(null);

        Intent serviceIntent = new Intent(SignupActivity.this, LocationJobIntentService.class);

        serviceIntent.putExtra("MYRESULTRECEIVER", myResultReceiver);

        LocationJobIntentService.enqueueWork(SignupActivity.this, serviceIntent);

    }

    private class MyResultReceiver extends ResultReceiver {


        public MyResultReceiver(Handler handler) {
            super(handler);

            System.out.println("MyResultReceiverIsCalled");
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);

            System.out.println("outside");

            if (resultCode == AppConstants.RESULT_CODE && resultData != null) {

                System.out.println("Inseide");

                dStLocLat = resultData.getDouble("MYLATITIDE");
                dStLocLong = resultData.getDouble("MYLONGITUTE");

                //addMyCurrentLocationInFireStore(lat, lon);

                //System.out.println("MYLATLONGI" + lat + " " + lon);



            }

        }
    }


    private void initView() {

        signUpName = (EditText) findViewById(R.id.signup_name);
        signUpEmail = (EditText) findViewById(R.id.signup_email);
        signUpMobile = (EditText) findViewById(R.id.signup_mobile);
        signUpPassword = (EditText) findViewById(R.id.signup_password);
        signUpCPassword = (EditText) findViewById(R.id.confirm_password);

        dAddress=(TextView)findViewById(R.id.dstore_address);

        btnSignUp = (Button) findViewById(R.id.btnSignup);

    }

    private void validateSignupRequest(String userName, String userEmail, String userMobile, String userPassword, String userCPassword) {
        if (!Validation.validateEmptyString(userName)) {

            Toast.makeText(SignupActivity.this, "Please Enter Name", Toast.LENGTH_LONG).show();
            return;

        }

        if (!Validation.validateEmptyString(userEmail)) {

            Toast.makeText(SignupActivity.this, "Please Enter Email", Toast.LENGTH_LONG).show();
            return;

        }

        if (!Validation.validateEmptyString(userMobile)) {

            Toast.makeText(SignupActivity.this, "Please Enter Mobile Number", Toast.LENGTH_LONG).show();
            return;

        }
        if (!Validation.validateEmptyString(userPassword)) {

            Toast.makeText(SignupActivity.this, "Please Enter Password", Toast.LENGTH_LONG).show();
            return;

        }
        if (!Validation.validateEmptyString(userCPassword)) {

            Toast.makeText(SignupActivity.this, "Please Enter Confirm Password", Toast.LENGTH_LONG).show();
            return;

        }

        if(!validateEmail(userEmail)){
            Toast.makeText(SignupActivity.this, "Invalid Email", Toast.LENGTH_LONG).show();
            signUpEmail.findFocus();
            return;
        }

        if(!Validation.validateMobileNumberLength(userMobile)){
            Toast.makeText(SignupActivity.this, "Mobile number should be in 10 digits", Toast.LENGTH_LONG).show();
            signUpMobile.findFocus();
            return;
        }

        if(!validateMobileNumber(userMobile)){
            Toast.makeText(SignupActivity.this, "Invalid Mobile Number", Toast.LENGTH_LONG).show();
            signUpMobile.findFocus();
            return;
        }

        if(userMobile.equals("0000000000")){
            Toast.makeText(SignupActivity.this, "Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
            signUpMobile.findFocus();
            return;
        }

        if(!validatePassword(userPassword)){
            Toast.makeText(SignupActivity.this, "Password should have minimum 6 characters", Toast.LENGTH_LONG).show();
            signUpPassword.findFocus();
            return;
        }

        if(userPassword.contains(" ")){
            Toast.makeText(SignupActivity.this, "Password should not have space", Toast.LENGTH_LONG).show();
            signUpPassword.findFocus();
            return;
        }

        if(userCPassword.contains(" ")){
            Toast.makeText(SignupActivity.this, "Confirm Password should not have space", Toast.LENGTH_LONG).show();
            signUpCPassword.findFocus();
            return;
        }

        if(!validatePassword(userCPassword)){
            Toast.makeText(SignupActivity.this, "Confirm Password should have minimum 6 characters", Toast.LENGTH_LONG).show();
            signUpCPassword.findFocus();
            return;
        }

        if(!userPassword.equals(userCPassword)){
            Toast.makeText(SignupActivity.this, "Password and Confirm Password Mismatch", Toast.LENGTH_LONG).show();
            return;
        }

    }

}