package com.ldh.smarthouse.View.House;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ldh.smarthouse.Const.Default;
import com.ldh.smarthouse.Model.DeviceRoom;
import com.ldh.smarthouse.R;

import java.util.ArrayList;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {
    private ArrayList<DeviceRoom> deviceRooms = new ArrayList<>();
    private DeviceClickListener deviceClickListener;

    public void setData(ArrayList<DeviceRoom> deviceRooms) {
        this.deviceRooms = deviceRooms;
        notifyDataSetChanged();
    }

    public DeviceAdapter(ArrayList<DeviceRoom> deviceRooms, DeviceClickListener deviceClickListener) {
        this.deviceRooms = deviceRooms;
        this.deviceClickListener = deviceClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (deviceRooms.size() > 0) {
            DeviceRoom deviceRoom = deviceRooms.get(position);
            if (deviceRoom != null) {
                holder.ibDevice.setImageResource(Default.devices.get(deviceRoom.getDevice_id() - 1).getImage());
                holder.switchDevice.setChecked(deviceRoom.getIs_active() > 0);
                if (deviceRoom.getParam().length()>0) {
                    holder.llDegree.setVisibility(View.VISIBLE);
                    holder.tvDegree.setText(deviceRoom.getParam() + "");
                } else
                    holder.llDegree.setVisibility(View.INVISIBLE);
                if (position%2==0){
                    holder.tvDeviceName.setText("Điều hòa Panasonic 9000BTU");
                    holder.tvDeviceDetail.setText("Panasonic");
                }
                else{
                    holder.tvDeviceName.setText("Smart TV LG 43 inch FULL HD");
                    holder.tvDeviceDetail.setText("GL");
                }

            }
        }
    }

    @Override
    public int getItemCount() {
        return deviceRooms.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageButton ibDevice;
        private Switch switchDevice;
        private TextView tvDegree, tvDeviceName, tvDeviceDetail;
        private LinearLayout llDegree;
        private DeviceClickListener _deviceClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ibDevice = itemView.findViewById(R.id.ibDevice);
            switchDevice = itemView.findViewById(R.id.switchDevice);
            tvDegree = itemView.findViewById(R.id.tvDegree);
            tvDeviceName = itemView.findViewById(R.id.tvDeviceName);
            tvDeviceDetail = itemView.findViewById(R.id.tvDeviceDetail);
            llDegree = itemView.findViewById(R.id.llDegree);
            _deviceClickListener = deviceClickListener;
            switchDevice.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deviceClickListener.onSwitchDevice(getAdapterPosition());
                }
            });
            llDegree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    deviceClickListener.onDegreeClick(getAdapterPosition());
                }
            });

        }
    }
}
