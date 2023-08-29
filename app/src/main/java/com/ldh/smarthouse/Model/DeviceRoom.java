package com.ldh.smarthouse.Model;

import java.util.Date;

public class DeviceRoom {
    private String code = "";
    private int id = -1;
    private int device_id = -1;
    private int room_id = -1;
    private int is_active = -1;
    private String param = "";
    private String device_name = "Refridgator";
    private String device_detail="Panasonic";
    private String created_at = "";
    private String updated_at = "";
    private Device device = new Device();
    public DeviceRoom(String code, int _id, int device_id, int room_id, int is_active, String param, String created_at, String updated_at) {
        this.code = code;
        this.id = _id;
        this.device_id = device_id;
        this.room_id = room_id;
        this.is_active = is_active;
        this.param = param;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
   /**
    * @param code :code of device
    * @param id :id of device
    * @param room_id: id of room which has device
    * @param is_active: device on or off
    * @param param: other field
    * @param device:type of device
    * **/
    public DeviceRoom(int id,String code, Device device,  int room_id, int is_active, String param) {
        this.code = code;
        this.id = id;
        this.room_id = room_id;
        this.is_active = is_active;
        this.param = param;
        this.device = device;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_detail() {
        return device_detail;
    }

    public void setDevice_detail(String device_detail) {
        this.device_detail = device_detail;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
