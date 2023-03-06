package com.ldh.smarthouse.Model;

import java.util.Date;

public class Device {
    private int id = -1;
    private String name = "";
    private Date created_at = new Date();
    private Date updated_at = new Date();
    private int image;
    public Device(int id, String name, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Device(int id, String name,int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
   public Device(){}
    public int get_id() {
        return id;
    }

    public void set_id(int _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
