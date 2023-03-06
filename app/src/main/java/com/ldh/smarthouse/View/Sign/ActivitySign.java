package com.ldh.smarthouse.View.Sign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.ldh.smarthouse.R;

public class ActivitySign extends AppCompatActivity {
   private TabLayout tlSign;
   private ViewPager vpSign;
    private SignViewPagerAdapter vpSignAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ldh.smarthouse.R.layout.activity_sign);
        findId();
        vpSign.setAdapter(vpSignAdapter);
        tlSign.setupWithViewPager(vpSign);
    }
    public void findId() {
        tlSign = findViewById(R.id.tlSign);
        vpSign = findViewById(R.id.vpSign);
        vpSignAdapter = new SignViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

    }
}