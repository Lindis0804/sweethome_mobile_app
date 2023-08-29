package com.ldh.smarthouse.View.House;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ldh.smarthouse.R;

public class BSDeviceInfo extends BottomSheetDialogFragment {
    private TextView tvDeviceName,tvDeviceDetail;
    private EditText etDeviceName,etDeviceDetail;
    private AppCompatButton bCancel,bUpdate;
    private String deviceName="",deviceDetail="";
    private int pos;
    private UpdateParamListener updateParamListener;
    private ImageButton ibUpdate;
    private LinearLayout llCancelUpdate;
    private ViewSwitcher vsDeviceName,vsDeviceDetail;
    public BSDeviceInfo(int pos,String deviceName, String deviceDetail,UpdateParamListener updateParamListener) {
        this.deviceName = deviceName;
        this.deviceDetail = deviceDetail;
        this.pos = pos;
        this.updateParamListener = updateParamListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bs_device_info,container,false);
        findId(v);
        bUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateParamListener.updateDevice(pos);
            }
        });
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bCancel.setVisibility(View.INVISIBLE);
                bUpdate.setVisibility(View.INVISIBLE);
            }
        });
        tvDeviceName.setText(deviceName);
        tvDeviceDetail.setText(deviceDetail);
        ibUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Update device info.", Toast.LENGTH_SHORT).show();
                llCancelUpdate.setVisibility(View.VISIBLE);
                vsDeviceName.showNext();
                vsDeviceDetail.showNext();
                etDeviceName.setText(deviceName);
                etDeviceDetail.setText(deviceDetail);
            }
        });
        return v;
    }
    public void findId(View v){
        tvDeviceName = v.findViewById(R.id.tvDeviceName);
        tvDeviceDetail = v.findViewById(R.id.tvDeviceDetail);
        bCancel = v.findViewById(R.id.bCancel);
        bUpdate = v.findViewById(R.id.bUpdate);
        ibUpdate = v.findViewById(R.id.ibUpdate);
        llCancelUpdate = v.findViewById(R.id.llCancelUpdate);
        vsDeviceName = v.findViewById(R.id.vsDeviceName);
        vsDeviceDetail = v.findViewById(R.id.vsDeviceDetail);
        tvDeviceName = vsDeviceName.findViewById(R.id.tvDeviceName);
        etDeviceName = vsDeviceName.findViewById(R.id.etDeviceName);
        tvDeviceDetail = vsDeviceDetail.findViewById(R.id.tvDeviceDetail);
        etDeviceDetail = vsDeviceDetail.findViewById(R.id.etDeviceDetail);
    }

    public String getDeviceNameFromEditText() {
        return etDeviceName.getText().toString().trim();
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        vsDeviceName.showPrevious();
        tvDeviceName.setText(deviceName);
    }

    public String getDeviceDetailFromEditText() {
        return etDeviceDetail.getText().toString().trim();
    }

    public void setDeviceDetail(String deviceDetail) {
        this.deviceDetail = deviceDetail;
        vsDeviceDetail.showPrevious();
        tvDeviceDetail.setText(deviceDetail);
    }

}
