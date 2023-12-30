package com.ldh.smarthouse.Model.Response;

import com.google.gson.annotations.SerializedName;
import com.ldh.smarthouse.Model.House;

import java.util.ArrayList;

public class GetHousesResult {
    @SerializedName("houses")
    private ArrayList<House> houses = new ArrayList<>();

    public ArrayList<House> getHouses() {
        return houses;
    }

    public void setHouses(ArrayList<House> houses) {
        this.houses = houses;
    }

    public GetHousesResult(ArrayList<House> houses) {
        this.houses = houses;
    }
}
