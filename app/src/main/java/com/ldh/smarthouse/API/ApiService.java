package com.ldh.smarthouse.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String url = "https://7c3a-2402-800-b2dd-da85-fcfb-2614-41c9-e2bf.ap.ngrok.io/";
    String macova = "http://192.168.1.173:8080/";
    String redmi = "http://192.168.146.212:8080/";
    ApiService apiService = new Retrofit.Builder().baseUrl(redmi).addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);

    //log inz
    @POST("/login_user")
    Call<DataResponse> logIn(@Body User user);

    @GET("/h/houses")
    Call<DataResponse> getHouses(@Header("Authorization") String token);

    @GET("/h/house/{houseId}/rooms")
    Call<DataResponse> getRooms(@Header("Authorization") String token, @Path("houseId") int houseId);

    @GET("/h/room/{roomId}/devices")
    Call<DataResponse> getDevices(@Header("Authorization") String token, @Path("roomId") int roomId);

    @PUT("/h/device/{deviceId}/control")
    Call<DataResponse> updateDeviceParam(@Header("Authorization") String token, @Path("deviceId") int deviceId, @Body DeviceRoom deviceRoom);

    //user
    @GET("/h/user_detail")
    Call<DataResponse> getUserById(@Header("Authorization") String token);
}
