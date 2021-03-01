package com.sosaley.sosy.dhome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sosaley.sosy.R;
import com.sosaley.sosy.dhome.dutils.Validation;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignUp;
    private EditText signUpName, signUpEmail, signUpMobile, signUpPassword, signUpCPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initView();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = signUpName.getText().toString().trim();
                String userEmail = signUpEmail.getText().toString().trim();
                String userMobile = signUpMobile.getText().toString().trim();
                String userPassword = signUpPassword.getText().toString().trim();
                String userCPassword = signUpCPassword.getText().toString().trim();

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

                if(!Validation.validateEmail(userEmail)){
                    Toast.makeText(SignupActivity.this, "Invalid Email", Toast.LENGTH_LONG).show();
                    signUpEmail.findFocus();
                    return;
                }

                if(!Validation.validateMobileNumberLength(userMobile)){
                    Toast.makeText(SignupActivity.this, "Mobile number should be in 10 digits", Toast.LENGTH_LONG).show();
                    signUpMobile.findFocus();
                    return;
                }

                if(!Validation.validateMobileNumber(userMobile)){
                    Toast.makeText(SignupActivity.this, "Invalid Mobile Number", Toast.LENGTH_LONG).show();
                    signUpMobile.findFocus();
                    return;
                }

                if(userMobile.equals("0000000000")){
                    Toast.makeText(SignupActivity.this, "Enter Valid Mobile Number", Toast.LENGTH_LONG).show();
                    signUpMobile.findFocus();
                    return;
                }

                if(!Validation.validatePassword(userPassword)){
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

                if(!Validation.validatePassword(userCPassword)){
                    Toast.makeText(SignupActivity.this, "Confirm Password should have minimum 6 characters", Toast.LENGTH_LONG).show();
                    signUpCPassword.findFocus();
                    return;
                }

                if(!userPassword.equals(userCPassword)){
                    Toast.makeText(SignupActivity.this, "Password and Confirm Password Mismatch", Toast.LENGTH_LONG).show();
                    return;
                }





            }
        });
    }

    private void initView() {

        signUpName = (EditText) findViewById(R.id.signup_name);
        signUpEmail = (EditText) findViewById(R.id.signup_email);
        signUpMobile = (EditText) findViewById(R.id.signup_mobile);
        signUpPassword = (EditText) findViewById(R.id.signup_password);
        signUpCPassword = (EditText) findViewById(R.id.confirm_password);

        btnSignUp = (Button) findViewById(R.id.btnSignup);

    }
}