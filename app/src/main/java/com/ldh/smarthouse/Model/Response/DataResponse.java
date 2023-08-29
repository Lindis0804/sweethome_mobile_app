package com.ldh.smarthouse.Model.Response;

import com.google.gson.annotations.SerializedName;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.Model.House;
import com.ldh.smarthouse.Model.Room;
import com.ldh.smarthouse.Model.User;

import java.util.ArrayList;

public class DataResponse {
    @SerializedName("access_token")
    private String access_token = "";
    @SerializedName("houses")
    private ArrayList<House> houses = new ArrayList<>();
    @SerializedName("message")
    private String message = "";
    public String getAccess_token() {
        return access_token;
    }
    @SerializedName("rooms")
    public ArrayList<Room> rooms = new ArrayList<>();
    @SerializedName("deviceRooms")
    public ArrayList<DeviceRoom> deviceRooms = new ArrayList<>();
    private DeviceRoom deviceRoom =null;
    private User user;
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<DeviceRoom> getDeviceRooms() {
        return deviceRooms;
    }

    public void setDeviceRooms(ArrayList<DeviceRoom> deviceRooms) {
        this.deviceRooms = deviceRooms;
    }

    public DeviceRoom getDeviceRoom() {
        return deviceRoom;
    }

    public void setDeviceRoom(DeviceRoom deviceRoom) {
        this.deviceRoom = deviceRoom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
