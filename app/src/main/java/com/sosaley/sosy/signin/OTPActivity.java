package com.sosaley.sosy.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.sosaley.sosy.R;
import com.sosaley.sosy.homescreen.BottomTabbedActivity;
import com.sosaley.sosy.utils.ToastUtils;

import java.util.concurrent.TimeUnit;

public class OTPActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    EditText editText;
    Button otpSubmit;

    String verificationId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        editText = (EditText) findViewById(R.id.otpReceiver);
        otpSubmit = (Button) findViewById(R.id.otpSubmit);


        mAuth = FirebaseAuth.getInstance();

        String number="+919123521374";

        sendVerificationCode(number);


        otpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editText.getText().toString().trim();

                if (code != null) {
                    verifyCode(code);
                }else {
                    ToastUtils.getInstance(OTPActivity.this).showShortToast("Please enter OTP");


                }
            }
        });


    }

    void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            Intent intent=new Intent(OTPActivity.this, BottomTabbedActivity.class);
                            startActivity(intent);


                            ToastUtils.getInstance(OTPActivity.this).showLongToast("OTP Verified Successfully");

                        } else {
                            ToastUtils.getInstance(OTPActivity.this).showLongToast(task.getException().getMessage());
                        }

                    }
                });
    }


    private void sendVerificationCode(String number) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                changedCallbacks

        );

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks changedCallbacks=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationId=s;

        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            String code=phoneAuthCredential.getSmsCode();

            if (code != null) {

                verifyCode(code);
            }

        }


        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(OTPActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
    };


}
