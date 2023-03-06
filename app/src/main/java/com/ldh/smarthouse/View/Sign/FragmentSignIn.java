package com.ldh.smarthouse.View.Sign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.ldh.smarthouse.API.ApiService;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.User;
import com.ldh.smarthouse.R;
import com.ldh.smarthouse.View.Homepage.ActivityHomepage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSignIn extends Fragment {
    private AppCompatButton bSignIn;
    private TextInputEditText tietGmail,tietPassword;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_in,container,false);
        findId(v);
        bSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gmail = tietGmail.getText().toString().trim();
                String password = tietPassword.getText().toString().trim();
                User user = new User(gmail,password);
                ApiService.apiService.logIn(user).enqueue(new Callback<DataResponse>() {
                    @Override
                    public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                        if (response.code()==200) {
                            Log.v("TAG","Log in successfully.");
                            DataResponse res = response.body();
                            SharedPreferences.Editor editor = getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE).edit();
                            editor.putString("token","Bearer "+res.getAccess_token());
                            editor.commit();
                            startActivity(new Intent(getActivity(), ActivityHomepage.class));
                        }
                        else{
                            Toast.makeText(getActivity(), "Wrong email or password.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DataResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), "Log in fail.", Toast.LENGTH_SHORT).show();
                        Log.v("TAG",t.getMessage());
                    }
                });
            }
        });
        return v;
    }
    public void findId(View v){
        bSignIn = v.findViewById(R.id.bSignIn);
        tietGmail = v.findViewById(R.id.tietGmail);
        tietPassword = v.findViewById(R.id.tietPassword);
    }
}
