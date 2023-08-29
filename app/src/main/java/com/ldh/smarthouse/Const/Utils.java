package com.ldh.smarthouse.Const;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ldh.smarthouse.View.Sign.ActivitySign;

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
    public static void redirectToActivitySign(Context context, FragmentActivity activity){
        Intent intent = new Intent(context, ActivitySign.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }
    public static String getToken(FragmentActivity activity){
        String token = activity.getSharedPreferences("UserInfo",Context.MODE_PRIVATE).getString("token","");
        return token;
    }
}
