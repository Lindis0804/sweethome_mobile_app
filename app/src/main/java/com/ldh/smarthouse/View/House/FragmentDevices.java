package com.ldh.smarthouse.View.House;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ldh.smarthouse.API.ApiService;
import com.ldh.smarthouse.Const.Utils;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.Model.Response.DataResponse;
import com.ldh.smarthouse.Model.Response.GetDevicesRoomResult;
import com.ldh.smarthouse.Model.Response.UpdateDeviceRoomResult;
import com.ldh.smarthouse.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentDevices extends Fragment implements DeviceClickListener, UpdateParamListener {
    private RecyclerView rvDevices;
    private ArrayList<DeviceRoom> deviceRooms = new ArrayList<>();
    private int roomId;
    private DeviceAdapter deviceAdapter;
    private String token;
    private BSAdjustDegree bsAdjustDegree;
    private BSDeviceInfo bsDeviceInfo;
    public FragmentDevices(ArrayList<DeviceRoom> deviceRooms) {
        this.deviceRooms = deviceRooms;
    }

    public FragmentDevices() {
    }

    public FragmentDevices(int roomId) {
        this.roomId = roomId;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_devices, container, false);
        findId(v);
        token = requireActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE).getString("token", "");
        deviceAdapter = new DeviceAdapter(deviceRooms, FragmentDevices.this);
        Utils.setRecyclerView(rvDevices, deviceAdapter, new GridLayoutManager(
                getContext(),
                2
        ));
        getDeviceRooms();
        return v;
    }

    public void findId(View v) {
        rvDevices = v.findViewById(R.id.rvDevices);
    }

    @Override
    public void onSwitchDevice(int i) {
        int is_active = deviceRooms.get(i).getIs_active();
        if (is_active > 0) is_active = 0;
        else is_active = 1;
        deviceRooms.get(i).setIs_active(is_active);
        deviceAdapter.setData(deviceRooms);
        ApiService.apiService.updateDeviceParam(token, deviceRooms.get(i).getId(), deviceRooms.get(i)).enqueue(new Callback<UpdateDeviceRoomResult>() {
            @Override
            public void onResponse(Call<UpdateDeviceRoomResult> call, Response<UpdateDeviceRoomResult> response) {
                if (response.code() == 200) {
                    Toast.makeText(getActivity(), "Update device param successfully.", Toast.LENGTH_SHORT).show();
                    Log.v("TAG", "Update device param successfully.");
                } else {
                    Toast.makeText(getActivity(), "Cannot update device param.", Toast.LENGTH_SHORT).show();
                    Log.v("TAG", "Can not update device param.");
                }
            }

            @Override
            public void onFailure(Call<UpdateDeviceRoomResult> call, Throwable t) {
                Toast.makeText(getActivity(), "Error in calling update device param api.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDegreeClick(int i) {
        bsAdjustDegree = new BSAdjustDegree(i, Integer.parseInt(deviceRooms.get(i).getParam()), FragmentDevices.this);
        bsAdjustDegree.show(requireActivity().getSupportFragmentManager(), "BSAdjustDegree");
    }

    @Override
    public void onDeviceInfoClick(int i) {
        bsDeviceInfo = new BSDeviceInfo(i,deviceRooms.get(i).getDevice_name(),deviceRooms.get(i).getDevice_detail(),FragmentDevices.this);
        bsDeviceInfo.show(requireActivity().getSupportFragmentManager(),"BSDeviceInfo");
    }

    public void getDeviceRooms() {
        ApiService.apiService.getDevices(token, roomId).enqueue(new Callback<GetDevicesRoomResult>() {
            @Override
            public void onResponse(Call<GetDevicesRoomResult> call, Response<GetDevicesRoomResult> response) {
                if (response.code() == 200) {
                    GetDevicesRoomResult res = response.body();
                    deviceRooms = res.getDeviceRooms();
                    deviceAdapter.setData(deviceRooms);
                } else {
                    Log.v("TAG", "Can not get device rooms");
                }
            }

            @Override
            public void onFailure(Call<GetDevicesRoomResult> call, Throwable t) {
                Log.v("TAG", "Error in calling get deviceRooms api :" + t.getMessage());
            }
        });
    }

    @Override
    public void increaseDegree(int i) {
        int degree = Integer.parseInt(deviceRooms.get(i).getParam());
        if (degree < 50) {
            degree += 1;
            deviceRooms.get(i).setParam(degree + "");
            bsAdjustDegree.setDegree(degree);
            deviceAdapter.setData(deviceRooms);
            ApiService.apiService.updateDeviceParam(token, deviceRooms.get(i).getId(), deviceRooms.get(i)).enqueue(new Callback<UpdateDeviceRoomResult>() {
                @Override
                public void onResponse(Call<UpdateDeviceRoomResult> call, Response<UpdateDeviceRoomResult> response) {
                    if (response.code() == 200) {
                        //Toast.makeText(getActivity(), "Update device param successfully.", Toast.LENGTH_SHORT).show();
                        Log.v("TAG","Update device param successfully.");
                    } else {
                        Toast.makeText(getActivity(), "Cannot update device param.", Toast.LENGTH_SHORT).show();
                        Log.v("TAG", "Can not update device param.");
                    }
                }

                @Override
                public void onFailure(Call<UpdateDeviceRoomResult> call, Throwable t) {
                    Toast.makeText(getActivity(), "Error in calling update device param api.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void decreaseDegree(int i) {
        int degree = Integer.parseInt(deviceRooms.get(i).getParam());
        if (degree > 0) {
            degree -= 1;
            deviceRooms.get(i).setParam(degree + "");
            bsAdjustDegree.setDegree(degree);
            deviceAdapter.setData(deviceRooms);
            ApiService.apiService.updateDeviceParam(token, deviceRooms.get(i).getId(), deviceRooms.get(i)).enqueue(new Callback<UpdateDeviceRoomResult>() {
                @Override
                public void onResponse(Call<UpdateDeviceRoomResult> call, Response<UpdateDeviceRoomResult> response) {
                    if (response.code() == 200) {
                       // Toast.makeText(getActivity(), "Update device param successfully.", Toast.LENGTH_SHORT).show();
                        Log.v("TAG","Update device param successfully.");
                    } else {
                        Toast.makeText(getActivity(), "Cannot update device param.", Toast.LENGTH_SHORT).show();
                        Log.v("TAG", "Can not update device param.");
                    }
                }

                @Override
                public void onFailure(Call<UpdateDeviceRoomResult> call, Throwable t) {
                    Toast.makeText(getActivity(), "Error in calling update device param api.", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void updateDevice(int i) {
           String deviceName = bsDeviceInfo.getDeviceNameFromEditText();
           String deviceDetail = bsDeviceInfo.getDeviceDetailFromEditText();
           DeviceRoom deviceRoom = deviceRooms.get(i);
           deviceRoom.setDevice_name(deviceName);
           deviceRoom.setDevice_detail(deviceDetail);
           ApiService.apiService.updateDeviceParam(token,deviceRoom.getId(),deviceRoom).enqueue(new Callback<UpdateDeviceRoomResult>() {
               @Override
               public void onResponse(Call<UpdateDeviceRoomResult> call, Response<UpdateDeviceRoomResult> response) {
                   if (response.code() == 200){
                       deviceRooms.remove(i);
                       deviceRooms.add(i,deviceRoom);
                       deviceAdapter.setData(deviceRooms);
                       Toast.makeText(getContext(), "Update device param successfully.", Toast.LENGTH_SHORT).show();
                       Log.v("TAG","Update device param successfully.");
                       bsDeviceInfo.dismiss();
                   }
                   else{
                       Log.v("TAG","Can not update device param.");
                   }
               }

               @Override
               public void onFailure(Call<UpdateDeviceRoomResult> call, Throwable t) {
                    Log.v("TAG","Can not call update device param api :"+t.getMessage());
               }
           });
    }
}
