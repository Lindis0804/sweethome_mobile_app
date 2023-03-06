package com.ldh.smarthouse.Model.Response;

import com.google.gson.annotations.SerializedName;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.Model.House;
import com.ldh.smarthouse.Model.Room;

import java.util.ArrayList;

public class DataResponse {
    @SerializedName("access_token")
    private String access_token = "";
    private ArrayList<House> houses = new ArrayList<>();
    private String message = "";
    public String getAccess_token() {
        return access_token;
    }
    public ArrayList<Room> rooms = new ArrayList<>();
    public ArrayList<DeviceRoom> deviceRooms = new ArrayList<>();
    private DeviceRoom deviceRoom =null;
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
}
