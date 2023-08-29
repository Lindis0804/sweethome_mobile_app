package com.ldh.smarthouse.Model;

import java.util.ArrayList;

public class User {
    private int id = -1;
    private String name = "";
    private String phone_number = "";
    private String email = "";
    private String password="";
    private int role = -1;
    private  String avatar,wallpaper;
    private ArrayList<House> houses = new ArrayList<>();

    public User(int id, String name, String phone_number, String email, String password, int role, ArrayList<House> houses) {
        this.id = id;
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.role = role;
        this.houses = houses;
    }

    public int getId() {
        return id;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(String wallpaper) {
        this.wallpaper = wallpaper;
    }
}
