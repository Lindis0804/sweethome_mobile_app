package com.ldh.smarthouse.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.Model.House;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String url = "https://5e0d-116-107-153-53.ap.ngrok.io/";
    String macova = "http://192.168.1.173:8080/";
    String redmi = "http://192.168.235.212:8080/";
    ApiService apiService = new Retrofit.Builder().baseUrl(redmi).addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);

    //log in
    @POST("/login")
    Call<DataResponse> logIn(@Body User user);

    @GET("/house")
    Call<DataResponse> getHouses(@Header("Authorization") String token);

    @GET("/house/{houseId}/rooms")
    Call<DataResponse> getRooms(@Header("Authorization") String token, @Path("houseId") int houseId);

    @GET("/room/{roomId}/devices")
    Call<DataResponse> getDevices(@Header("Authorization") String token, @Path("roomId") int roomId);
    @PUT("/device/{deviceId}/control")
    Call<DataResponse> updateDeviceParam(@Header("Authorization") String token, @Path("deviceId") int deviceId, @Body DeviceRoom deviceRoom);
}
