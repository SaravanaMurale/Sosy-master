package com.sosaley.sosy.signin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputLayout;
import com.shobhitpuri.custombuttons.GoogleSignInButton;
import com.sosaley.sosy.R;

import static com.sosaley.sosy.utils.AppConstant.RESOLVE_HINT;
import static com.sosaley.sosy.utils.MathUtil.validateMobile;
import static com.sosaley.sosy.utils.MathUtil.validatePassword;

public class LoginActivity extends AppCompatActivity {

    private EditText loginMobile, loginPassword;
    private TextInputLayout inputLoginMobile, inputLoginPassword;
    private Button btnSignIn;

    GoogleSignInButton gmailSignup;

    GoogleApiClient mCredentialsApiClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputLoginMobile = (TextInputLayout) findViewById(R.id.input_login_mobile);
        inputLoginPassword = (TextInputLayout) findViewById(R.id.input_login_password);

        loginMobile = (EditText) findViewById(R.id.login_mobile);
        loginPassword = (EditText) findViewById(R.id.login_password);

        gmailSignup = (GoogleSignInButton) findViewById(R.id.gmailSignup);

        btnSignIn = (Button) findViewById(R.id.btn_login);

        mCredentialsApiClient = new GoogleApiClient.Builder(this)
                /*.addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) HomeActivity.this)
                .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) HomeActivity.this)*/
                .addApi(Auth.CREDENTIALS_API)
                //.setAccountName(IdentityProviders.FACEBOOK)
                .build();



        loginMobile.addTextChangedListener(new MyTextWatcher(loginMobile));
        loginPassword.addTextChangedListener(new MyTextWatcher(loginPassword));


        gmailSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestHint();
            }
        });

    }


    private void requestHint() {

        mCredentialsApiClient.connect();

        HintRequest hintRequest = new HintRequest.Builder()
                //.setPhoneNumberIdentifierSupported(true)
                .setEmailAddressIdentifierSupported(true)
                .build();


        PendingIntent intent = Auth.CredentialsApi.getHintPickerIntent(
                mCredentialsApiClient, hintRequest);
        try {
            startIntentSenderForResult(intent.getIntentSender(),
                    RESOLVE_HINT, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESOLVE_HINT) {
            if (resultCode == RESULT_OK) {
                Credential credential = data.getParcelableExtra(Credential.EXTRA_KEY);

                System.out.println("GmailUserID" + credential.getId());
                System.out.println("GmailUser" + credential.getName() + " " + credential.getPassword() + " " + credential.getId() + " " + credential.getIdTokens());

            }
        }


    }


    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            String mobile = loginMobile.getText().toString().trim();
            String password = loginPassword.getText().toString().trim();

            btnSignIn.setEnabled(validateMobile(mobile) && validatePassword(password));

            if (btnSignIn.isEnabled()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btnSignIn.setBackground(getDrawable(R.drawable.rectangle_shpae));
                }
            } else if (!btnSignIn.isEnabled()) {
                btnSignIn.setEnabled(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btnSignIn.setBackground(getDrawable(R.color.btn_disable));
                }
            }

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }


}
