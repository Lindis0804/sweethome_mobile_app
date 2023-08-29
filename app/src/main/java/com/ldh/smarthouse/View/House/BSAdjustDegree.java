package com.ldh.smarthouse.View.House;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ldh.smarthouse.R;

public class BSAdjustDegree extends BottomSheetDialogFragment {
    private int pos;
    private int degree;
    private ImageButton ibIncreaseDegree, ibDecreaseDegree;
    private UpdateParamListener adjustDegreeListener;
    private TextView tvDegree;

    public BSAdjustDegree(int pos, int degree, UpdateParamListener adjustDegreeListener) {
        this.pos = pos;
        this.degree = degree;
        this.adjustDegreeListener = adjustDegreeListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bs_adjust_degree, container, false);
        findId(v);
        tvDegree.setText(degree+"");
        ibIncreaseDegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustDegreeListener.increaseDegree(pos);
            }
        });
        ibDecreaseDegree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustDegreeListener.decreaseDegree(pos);
            }
        });
        return v;
    }

    public void findId(View v) {
        ibDecreaseDegree = v.findViewById(R.id.ibDecreaseDegree);
        ibIncreaseDegree = v.findViewById(R.id.ibIncreaseDegree);
        tvDegree = v.findViewById(R.id.tvDegree);
    }

    public void setDegree(int degree) {
        tvDegree.setText(degree + "");
    }
}
