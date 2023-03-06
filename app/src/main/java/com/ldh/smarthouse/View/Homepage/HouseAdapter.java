package com.ldh.smarthouse.View.Homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ldh.smarthouse.Model.House;
import com.ldh.smarthouse.R;

import java.util.ArrayList;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.ViewHolder>{
    private ArrayList<House> houses = new ArrayList<>();
    private HouseClickListener houseClickListener;

    public HouseAdapter(ArrayList<House> houses, HouseClickListener houseClickListener) {
        this.houses = houses;
        this.houseClickListener = houseClickListener;
    }
   public void setData(ArrayList<House> houses){
        this.houses = houses;
        notifyDataSetChanged();
   }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.house_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        House house = houses.get(position);
        if (house!=null){
            holder.tvHouseName.setText(house.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (houses!=null)
        return houses.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvHouseName;
        private HouseClickListener _houseClickListener;
        private LinearLayout llHouse;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHouseName = itemView.findViewById(R.id.tvHouseName);
            llHouse = itemView.findViewById(R.id.llHouse);
            _houseClickListener = houseClickListener;
            llHouse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    _houseClickListener.onHouseClick(getAdapterPosition());
                }
            });
        }
    }
}
