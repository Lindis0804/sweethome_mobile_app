package com.ldh.smarthouse.View.Homepage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ldh.smarthouse.R;

public class ActivityHomepage extends AppCompatActivity {
     private ViewPager2 vpPage;
     private BottomNavigationView bnvPageOption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ldh.smarthouse.R.layout.activity_homepage);
        findId();
        VPPageAdapter adapter = new VPPageAdapter(this);
        vpPage.setAdapter(adapter);
        // swipe right or left to change page
        vpPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        bnvPageOption.getMenu().findItem(R.id.nav_homepage).setChecked(true);
                        break;
                    case 1:
                        bnvPageOption.getMenu().findItem(R.id.nav_profile).setChecked(true);
                        break;
                }
            }
        });
        // click on bottom navigation to change page
        bnvPageOption.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_homepage:
                        vpPage.setCurrentItem(0);
                        break;
                    case R.id.nav_profile:
                        vpPage.setCurrentItem(1);
                        break;
                }
                return true;
            }
        });
        //deep page transformer
        vpPage.setPageTransformer(new DeepPageTransformer());
    }
    public void findId(){
        vpPage = findViewById(R.id.vpPage);
        bnvPageOption = findViewById(R.id.bnvPageOption);
    }
}