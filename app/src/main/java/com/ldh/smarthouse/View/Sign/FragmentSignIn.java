package com.ldh.smarthouse.View.Sign;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.ldh.smarthouse.API.ApiService;
import com.ldh.smarthouse.Const.Constants;
import com.ldh.smarthouse.Const.PreferenceManager;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.Response.LoginResult;
import com.ldh.smarthouse.Model.User;
import com.ldh.smarthouse.R;
import com.ldh.smarthouse.View.Homepage.ActivityHomepage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSignIn extends Fragment {
    private AppCompatButton bSignIn;
    private TextInputEditText tietGmail, tietPassword;
    private ProgressBar pbLoadingSignIn;
    private PreferenceManager preferenceManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sign_in, container, false);
        findId(v);
        bSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingSignIn(true);
                String gmail = tietGmail.getText().toString().trim();
                String password = tietPassword.getText().toString().trim();
                User user = new User(gmail, password);
                ApiService.apiService.logIn(user).enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        loadingSignIn(false);
                        if (response.code() == 200) {
                            Log.v("TAG", "Log in successfully.");
                            LoginResult res = response.body();
                            preferenceManager = new PreferenceManager(requireContext());
                            preferenceManager.putString(Constants.KEY_TOKEN,"Bearer "+res.getAccess_token());
                            startActivity(new Intent(getActivity(), ActivityHomepage.class));
                        } else {
                            Toast.makeText(getActivity(), "Wrong email or password.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        loadingSignIn(false);
                        Toast.makeText(getActivity(), "Log in fail.", Toast.LENGTH_SHORT).show();
                        Log.v("TAG", t.getMessage());
                    }
                });
            }
        });
        return v;
    }

    public void findId(View v) {
        bSignIn = v.findViewById(R.id.bSignIn);
        tietGmail = v.findViewById(R.id.tietGmail);
        tietPassword = v.findViewById(R.id.tietPassword);
        pbLoadingSignIn = v.findViewById(R.id.pbLoadingSignIn);
    }

    public void loadingSignIn(boolean isLoadingSignIn) {
        if (isLoadingSignIn) {
            bSignIn.setVisibility(View.INVISIBLE);
            pbLoadingSignIn.setVisibility(View.VISIBLE);
        } else {
            bSignIn.setVisibility(View.VISIBLE);
            pbLoadingSignIn.setVisibility(View.INVISIBLE);
        }
    }
}
