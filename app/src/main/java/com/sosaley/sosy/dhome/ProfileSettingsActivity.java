package com.sosaley.sosy.dhome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sosaley.sosy.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileSettingsActivity extends AppCompatActivity {

    RelativeLayout profileBlock, emailBlock, mobileBlock, changePasswordBlock;

    TextView userName, email, mobile;

    CircleImageView profilePic;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);

        profilePic = (CircleImageView) findViewById(R.id.profilePic);

        userName = (TextView) findViewById(R.id.userName);
        email = (TextView) findViewById(R.id.email);
        mobile = (TextView) findViewById(R.id.mobile);

        profileBlock = (RelativeLayout) findViewById(R.id.profileBlock);
        emailBlock = (RelativeLayout) findViewById(R.id.emailBlock);
        mobileBlock = (RelativeLayout) findViewById(R.id.mobileBlock);
        changePasswordBlock = (RelativeLayout) findViewById(R.id.changePasswordBlock);


        profileBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog("Update Name", 1);

            }
        });

        emailBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog("Update Email", 2);

            }
        });

        mobileBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog("Update Mobile Number", 3);
            }
        });

        changePasswordBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog("Update Password", 4);

            }
        });


    }

    private void openDialog(String update_name, final int i) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = this.getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.layout_dialog_userprofile, null);

        final EditText update = (EditText) view.findViewById(R.id.updateName);
        update.setHint(update_name);

        builder.setView(view);

        builder.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (i == 1) {
                    //update name

                    /*boolean status = sqliteManager.updateUserName(update.getText().toString());
                    if (status) {
                        Toast.makeText(ProfileSettingsActivity.this, "Updated UserName", Toast.LENGTH_LONG).show();

                        getUserDetails();
                    }*/

                } else if (i == 2) {
                    //update Email


                } else if (i == 3) {

                    //update mobile


                } else if (i == 4) {
                    //update password



                    }
                }



        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}