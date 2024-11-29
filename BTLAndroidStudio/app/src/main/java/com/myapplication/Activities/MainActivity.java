package com.myapplication.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import com.myapplication.Adapters.ViewPageAdapter;
import com.myapplication.R;
import com.myapplication.databinding.ActivityMainBinding;

import com.myapplication.utilities.PreferenceManager;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding; //view binding thay the cho findViewById()
    private com.myapplication.utilities.PreferenceManager preferenceManager;

    //
    private ViewPager2 viewPage2;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferenceManager = new PreferenceManager(getApplicationContext());

        viewPage2 = findViewById(R.id.viewPage2);
        bottomNavigationView = findViewById(R.id.navigation);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(this);
        viewPage2.setAdapter(viewPageAdapter);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id== R.id.chat){
                    viewPage2.setCurrentItem(0);
                }else if(id ==R.id.friend){
                    viewPage2.setCurrentItem(1);
                }else if(id==R.id.pesonal){
                    viewPage2.setCurrentItem(2);
                }
                return true;
            }
        });
        viewPage2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.chat).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.friend).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.pesonal).setChecked(true);
                        break;
                }
            }
        });
    }
}