package com.ldh.smarthouse.Model.Response;

import com.google.gson.annotations.SerializedName;

public class UpdateDeviceRoomResult {
    @SerializedName("id")
    private int id;
    @SerializedName("is_active")
    private int isActive;
    @SerializedName("param")
    private String param;
    @SerializedName("room_id")
    private int roomId;
    @SerializedName("userId")
    private int userId;

    public UpdateDeviceRoomResult(int id, int isActive, String param, int roomId, int userId) {
        this.id = id;
        this.isActive = isActive;
        this.param = param;
        this.roomId = roomId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
