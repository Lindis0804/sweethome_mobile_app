package com.ldh.smarthouse.View.Profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.ldh.smarthouse.API.ApiService;
import com.ldh.smarthouse.Const.Utils;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.User;
import com.ldh.smarthouse.R;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentProfile extends Fragment {
    private String token;
    private ImageView ivWallpaper,ivAvatar;
    private TextView tvGmail,tvName,tvPhoneNumber;
    private AppCompatButton bEditProfile,bLogOut;
    private DataResponse res;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile,container,false);
        token = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE).getString("token","");
        findId(v);
        ApiService.apiService.getUserById(token).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if (response.code()==200){
                    res = response.body();
                    User user = res.getUser();
                    if (user !=null){
                        Glide.with(getActivity().getApplicationContext()).load(user.getAvatar()).into(ivAvatar);
                        Glide.with(getActivity().getApplicationContext()).load(user.getWallpaper()).into(ivWallpaper);
                        tvGmail.setText(user.getEmail());
                        tvName.setText(user.getName());
                        tvPhoneNumber.setText(user.getPhone_number());
                    }
                }
                else{
                    Log.v("TAG","Can not get user profile.");
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
               Log.v("TAG","Can not call get user profile api :"+t.getMessage());
            }
        });
        bLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSharedPreferences("UserInfo",Context.MODE_PRIVATE).edit().clear().apply();
                Toast.makeText(getActivity(), "Log out.", Toast.LENGTH_SHORT).show();
                Utils.redirectToActivitySign(getContext(),getActivity());
            }
        });
        return v;
    }
    public void findId(View v){
        ivWallpaper = v.findViewById(R.id.ivWallpaper);
        ivAvatar = v.findViewById(R.id.ivAvatar);
        tvGmail = v.findViewById(R.id.tvEmail);
        tvName = v.findViewById(R.id.tvName);
        tvPhoneNumber = v.findViewById(R.id.tvPhoneNumber);
        bEditProfile = v.findViewById(R.id.bEditProfile);
        bLogOut = v.findViewById(R.id.bLogOut);
    }
}
