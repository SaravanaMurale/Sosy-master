package com.sosaley.sosy.homescreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sosaley.sosy.R;

public class BottomTabbedActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tabbed);

        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottomTabbedView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        selectedFragment=new HomeFragment();
        callMethod(selectedFragment);


    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            //Fragment selectedFragment=null;

            switch (menuItem.getItemId()){

                case R.id.menu_home:
                    selectedFragment=new HomeFragment();
                    break;

                case R.id.menu_search:
                    selectedFragment=new CommunityFragment();
                    break;

                case R.id.menu_cash:
                    selectedFragment=new ProfileFragment();
                    break;
            }


callMethod(selectedFragment);

            return true;
        }


    };

    private void callMethod(Fragment selectedFragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
    }

}
