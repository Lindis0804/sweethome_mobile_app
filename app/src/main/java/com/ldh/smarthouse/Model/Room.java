package com.ldh.smarthouse.Model;

import java.util.Date;

public class Room {
    private int id=-1;
    private int house_id=-1;
    private String name="";
    private String created_at="";
    private String updated_at="";

    public Room(int id, int house_id, String name, String created_at, String updated_at) {
        this.id = id;
        this.house_id = house_id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Room(int id, int house_id, String name) {
        this.id = id;
        this.house_id = house_id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
