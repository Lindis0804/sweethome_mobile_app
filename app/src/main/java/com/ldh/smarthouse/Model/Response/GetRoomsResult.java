package com.ldh.smarthouse.Model.Response;

import com.google.gson.annotations.SerializedName;
import com.ldh.smarthouse.Model.Room;

import java.util.ArrayList;

public class GetRoomsResult {
    @SerializedName("rooms")
    public ArrayList<Room> rooms = new ArrayList<>();

    public GetRoomsResult(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}
