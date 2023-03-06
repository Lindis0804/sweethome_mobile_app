package com.ldh.smarthouse.Const;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Utils {
    public static void setSizeAndLayout(RecyclerView rv, int layout) {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(
                rv.getContext(),
                layout,
                false
        ));
    }

    public static void setRecyclerView(RecyclerView rv, RecyclerView.Adapter adapter, RecyclerView.LayoutManager layoutManager) {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }
}
