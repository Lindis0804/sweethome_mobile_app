package com.ldh.smarthouse.Model;

import java.util.Date;

public class House {
    private int id = -1;
    private int user_id = -1;
    private String name = "";
    private String address = "";
    private String created_at = "";
    private String updated_at = "";

    public House(int id, int user_id, String name, String address, String created_at, String updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public House(int id, int user_id, String name, String address) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
