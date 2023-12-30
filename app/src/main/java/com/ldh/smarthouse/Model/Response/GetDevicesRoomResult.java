package com.ldh.smarthouse.Model.Response;

import com.google.gson.annotations.SerializedName;
import com.ldh.smarthouse.Model.DeviceRoom;

import java.util.ArrayList;

public class GetDevicesRoomResult {
    @SerializedName("deviceRooms")
    public ArrayList<DeviceRoom> deviceRooms = new ArrayList<>();

    public GetDevicesRoomResult(ArrayList<DeviceRoom> deviceRooms) {
        this.deviceRooms = deviceRooms;
    }

    public ArrayList<DeviceRoom> getDeviceRooms() {
        return deviceRooms;
    }

    public void setDeviceRooms(ArrayList<DeviceRoom> deviceRooms) {
        this.deviceRooms = deviceRooms;
    }
}
