package com.sosaley.sosy.signin;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.textfield.TextInputLayout;
import com.shobhitpuri.custombuttons.GoogleSignInButton;
import com.sosaley.sosy.R;
import com.sosaley.sosy.homescreen.BottomTabbedActivity;
import com.sosaley.sosy.utils.MathUtil;
import com.sosaley.sosy.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import static com.sosaley.sosy.utils.AppConstant.RESOLVE_HINT;
import static com.sosaley.sosy.utils.MathUtil.validateMobile;
import static com.sosaley.sosy.utils.MathUtil.validatePassword;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputName, inputMobile, inputEmail, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutMobile, inputLayoutEmail, inputLayoutPassword;
    private Button btnSignUp;
    TextView login,skip;

    GoogleSignInButton gmailSignup;

    GoogleApiClient mCredentialsApiClient;

    //Fb
    CallbackManager callbackManager;
    LoginButton loginButton;

    Typeface typeface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getFont();

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutMobile = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);

        inputName = (EditText) findViewById(R.id.input_name);
        inputMobile = (EditText) findViewById(R.id.input_mobile);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);

        btnSignUp = (Button) findViewById(R.id.btn_signup);
        gmailSignup = (GoogleSignInButton) findViewById(R.id.gmailSignup);

        loginButton = (LoginButton) findViewById(R.id.fbSignup);


        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputMobile.addTextChangedListener(new MyTextWatcher(inputMobile));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        login = (TextView) findViewById(R.id.login);

        skip=(TextView)findViewById(R.id.skip);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUpActivity.this,BottomTabbedActivity.class);
                startActivity(intent);
            }
        });



        callbackManager = CallbackManager.Factory.create();

        mCredentialsApiClient = new GoogleApiClient.Builder(this)
                /*.addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks) HomeActivity.this)
                .addOnConnectionFailedListener((GoogleApiClient.OnConnectionFailedListener) HomeActivity.this)*/
                .addApi(Auth.CREDENTIALS_API)
                //.setAccountName(IdentityProviders.FACEBOOK)
                .build();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUpActivity.this, OTPActivity.class);
                startActivity(intent);
            }
        });

        gmailSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestHint();
            }
        });


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                System.out.println("FacebookLogin" + loginResult.getAccessToken().getUserId());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });

    }

    private void getFont() {

        typeface =MathUtil.getOctinPrisonFont(SignUpActivity.this);

    }

    AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            if (currentAccessToken == null) {
                Toast.makeText(SignUpActivity.this, "User Logged Out", Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(SignUpActivity.this, "User Logged In", Toast.LENGTH_LONG).show();
                loadUserProfile(currentAccessToken);
            }


        }
    };

    private void loadUserProfile(AccessToken currentAccessToken) {

        GraphRequest request = GraphRequest.newMeRequest(currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                try {
                    String firstName = object.getString("first_name");
                    String lastName = object.getString("last_name");
                    String email = object.getString("email");
                    String id = object.getString("id");

                    // String image_url="https://graph.facebook.com/"+id+ "picture?type=normal";

                    //info.setText(email);
                    System.out.println("FirstNameLastName " + firstName);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });


        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

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
        callbackManager.onActivityResult(requestCode, resultCode, data);
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

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            String name = inputName.getText().toString().trim();
            String mobile = inputMobile.getText().toString().trim();
            String email = inputEmail.getText().toString().trim();
            String password = inputPassword.getText().toString().trim();


            btnSignUp.setEnabled(!name.isEmpty() && validateMobile(mobile) && !email.isEmpty() && validatePassword(password));

            if (btnSignUp.isEnabled()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btnSignUp.setBackground(getDrawable(R.drawable.rectangle_shpae));
                }
            } else if (!btnSignUp.isEnabled()) {
                btnSignUp.setEnabled(false);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    btnSignUp.setBackground(getDrawable(R.color.btn_disable));
                }
            }


        }

        public void afterTextChanged(Editable editable) {

        }
    }


}


