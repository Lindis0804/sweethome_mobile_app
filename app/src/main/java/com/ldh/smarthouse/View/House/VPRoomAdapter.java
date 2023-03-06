package com.ldh.smarthouse.View.House;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ldh.smarthouse.API.ApiService;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.Room;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VPRoomAdapter extends FragmentStateAdapter {
    private ArrayList<Room> rooms = new ArrayList<>();

    public VPRoomAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Room> rooms) {
        super(fragmentManager, lifecycle);
        this.rooms = rooms;
    }

    public void setData(ArrayList<Room> rooms) {
        this.rooms = rooms;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Room room = rooms.get(position);
        return new FragmentDevices(room.getId());
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

}
