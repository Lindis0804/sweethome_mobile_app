package com.ldh.smarthouse.View.House;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ldh.smarthouse.API.ApiService;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.Room;
import com.ldh.smarthouse.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityHouse extends AppCompatActivity {
    private TextView tvDay, tvLocation, tvWeather, tvDegree;
    private ImageButton ibNoti;
    private TabLayout tlRooms;
    private ViewPager2 vpRooms;
    private VPRoomAdapter vpRoomAdapter;
    private ArrayList<Room> rooms = new ArrayList<>();
    private DataResponse res;
    private String token;
    private int houseId;
    private ImageButton ibBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ldh.smarthouse.R.layout.activity_house);
        findId();
        token = getSharedPreferences("UserInfo", MODE_PRIVATE).getString("token", "");
        houseId = getIntent().getIntExtra("houseId",-1);
        Log.v("TAG","houseId "+houseId);
        vpRoomAdapter = new VPRoomAdapter(getSupportFragmentManager(), getLifecycle(), rooms);
        vpRooms.setAdapter(vpRoomAdapter);
        new TabLayoutMediator(tlRooms, vpRooms, (tab, pos) -> {
            tab.setText(rooms.get(pos).getName());
        }).attach();
        getRooms();
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void findId() {
        tvDay = findViewById(R.id.tvDay);
        tvLocation = findViewById(R.id.tvLocation);
        tvWeather = findViewById(R.id.tvWeather);
        tvDegree = findViewById(R.id.tvDegree);
        ibNoti = findViewById(R.id.ibNoti);
        tlRooms = findViewById(R.id.tlRooms);
        vpRooms = findViewById(R.id.vpRooms);
        ibBack = findViewById(R.id.ibBack);
    }

    public void getRooms() {
        ApiService.apiService.getRooms(token, houseId).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.code() == 200) {
                    res = response.body();
                    rooms = res.getRooms();
                    vpRoomAdapter.setData(rooms);
                } else {
                    Log.v("TAG", "Cannot get rooms.");
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Log.v("TAG", "Error in calling get rooms api: " + t.getMessage());
            }
        });
    }
}