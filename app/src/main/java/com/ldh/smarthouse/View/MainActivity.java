package com.ldh.smarthouse.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ldh.smarthouse.R;
import com.ldh.smarthouse.View.Sign.ActivitySign;

public class MainActivity extends AppCompatActivity {
    private AppCompatButton bGetStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bGetStarted = findViewById(R.id.bGetStarted);
        bGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActivitySign.class));
            }
        });
    }
}