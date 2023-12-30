package com.ldh.smarthouse.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import com.ldh.smarthouse.Const.Constants;
import com.ldh.smarthouse.Const.PreferenceManager;
import com.ldh.smarthouse.R;
import com.ldh.smarthouse.View.Homepage.ActivityHomepage;
import com.ldh.smarthouse.View.Sign.ActivitySign;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreferenceManager preferenceManager = new PreferenceManager(getApplicationContext());
        String token = preferenceManager.getString(Constants.KEY_TOKEN);
        if (token != null){
            startActivity(new Intent(getApplicationContext(), ActivityHomepage.class));
        }
        AppCompatButton bGetStarted = findViewById(R.id.bGetStarted);
        bGetStarted.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ActivitySign.class)));
    }
}