package com.ldh.smarthouse.API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.Response.GetDevicesRoomResult;
import com.ldh.smarthouse.Model.Response.GetHousesResult;
import com.ldh.smarthouse.Model.Response.GetRoomsResult;
import com.ldh.smarthouse.Model.Response.LoginResult;
import com.ldh.smarthouse.Model.Response.UpdateDeviceRoomResult;
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
    String server = "https://sweet-home-geats.vercel.app/";
    ApiService apiService = new Retrofit.Builder().baseUrl(server)
            .addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);

    //log inz
    @POST("/login_user")
    Call<LoginResult> logIn(@Body User user);

    @GET("/h/houses")
    Call<GetHousesResult> getHouses(@Header("Authorization") String token);

    @GET("/h/house/{houseId}/rooms")
    Call<GetRoomsResult> getRooms(@Header("Authorization") String token, @Path("houseId") int houseId);

    @GET("/h/room/{roomId}/devices")
    Call<GetDevicesRoomResult> getDevices(@Header("Authorization") String token, @Path("roomId") int roomId);

    @PUT("/h/device/{deviceId}/control")
    Call<UpdateDeviceRoomResult> updateDeviceParam(@Header("Authorization") String token, @Path("deviceId") int deviceId, @Body DeviceRoom deviceRoom);

    //user
    @GET("/h/user_detail")
    Call<DataResponse> getUserById(@Header("Authorization") String token);
}
