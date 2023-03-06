package com.ldh.smarthouse.Const;

import com.ldh.smarthouse.Model.Device;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.Model.House;
import com.ldh.smarthouse.Model.Room;
import com.ldh.smarthouse.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Default {
    public static ArrayList<Room> rooms = new ArrayList<>(Arrays.asList(
            new Room(0,0,"phong ngu 1"),
            new Room(1,0,"phong ngu 2"),
            new Room(2,0,"phong khach"),
            new Room(3,1,"phong bep")
    ));
    public static ArrayList<House> houses = new ArrayList<>(Arrays.asList(
            new House(0,0,"Can ho so 1","Vinhome Ocean Park"),
            new House(1,1,"Can ho so 1","VinHome Ocean Park"),
            new House(12,2,"Can ho so 1","Vin home")
    ));
    public static ArrayList<Device> devices = new ArrayList<>(Arrays.asList(
            new Device(1,"den hoc", R.drawable.light_pub),
            new Device(2,"dieu hoa",R.drawable.air_conditioner),
            new Device(3,"tivi",R.drawable.tv_screen),
            new Device(4,"Tu lanh",R.drawable.fridge),
            new Device(5,"May giat",R.drawable.washing_machine),
            new Device(6,"May giat 2",R.drawable.washing_machine),
            new Device(7,"test 5",R.drawable.tv_screen),
            new Device(8,"tu lanh 2",R.drawable.fridge),
            new Device(9,"tu lanh 3",R.drawable.fridge)
    ));
    public static ArrayList<DeviceRoom> deviceRooms = new ArrayList<>(Arrays.asList(
            new DeviceRoom(1,"1E4N3P",devices.get(1),1,1,"{\"temperature\": 24}"),
            new DeviceRoom(2,"3D4E6K",devices.get(1),0,1,""),
            new DeviceRoom(3,"9M2R6T",devices.get(2),1,0,"")
    ));
}
