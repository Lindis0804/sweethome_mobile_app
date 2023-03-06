package com.ldh.smarthouse.View.Homepage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ldh.smarthouse.View.Profile.FragmentProfile;

public class VPPageAdapter extends FragmentStateAdapter {
    public VPPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentHomepage();
            case 1:
                return new FragmentProfile();
            default:
                return new FragmentHomepage();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
