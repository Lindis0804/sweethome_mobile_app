package com.ldh.smarthouse.View.Homepage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.ldh.smarthouse.API.ApiService;
import com.ldh.smarthouse.Const.Default;
import com.ldh.smarthouse.Const.Utils;
import com.ldh.smarthouse.Model.House;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.R;
import com.ldh.smarthouse.View.House.ActivityHouse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHomepage extends Fragment implements HouseClickListener {
    private TextView tvLocation,tvDegree,tvWeather,tvDay;
    private ImageButton ibNoti;
    private RecyclerView rvHouses;
    private HouseAdapter houseAdapter;
    private Gson gson = new Gson();
    private String token;
    ArrayList<House> houses = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homepage,container,false);
        findId(v);
        token = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE).getString("token","");
        houseAdapter = new HouseAdapter(houses,FragmentHomepage.this);
        Utils.setRecyclerView(rvHouses,houseAdapter,new LinearLayoutManager(
                getContext(),
                RecyclerView.VERTICAL,
                false
        ));
        getHouses();
        return v;
    }
    public void findId(View v){
        tvLocation = v.findViewById(R.id.tvLocation);
        tvDegree = v.findViewById(R.id.tvDegree);
        tvWeather = v.findViewById(R.id.tvWeather);
        tvDay = v.findViewById(R.id.tvDay);
        ibNoti = v.findViewById(R.id.ibNoti);
        rvHouses = v.findViewById(R.id.rvHouses);
    }
   public void getHouses(){
       ApiService.apiService.getHouses(token).enqueue(new Callback<DataResponse>() {
           @Override
           public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
               if (response.code() == 200){
                   Log.v("TAG","Get houses successfully.");
                   DataResponse res = response.body();
                   houses = res.getHouses();
                   houseAdapter.setData(houses);
               }
               else{
                   Log.v("TAG","Error code :"+response.code());
               }
           }

           @Override
           public void onFailure(Call<DataResponse> call, Throwable t) {
              Log.v("TAG","Get houses "+t.getMessage());
           }
       });
   }
    @Override
    public void onHouseClick(int i) {
         Intent intent = new Intent(getContext(), ActivityHouse.class);
         intent.putExtra("houseId",houses.get(i).getId());
         startActivity(intent);
    }
}
