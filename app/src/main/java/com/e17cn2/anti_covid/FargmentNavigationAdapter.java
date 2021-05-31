package com.e17cn2.anti_covid;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FargmentNavigationAdapter extends FragmentStatePagerAdapter {
    private int numPage=4;
    public FargmentNavigationAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentHome();
            case 1: return new FragmentList();
            case 2: return new FragmentCorona();
            case 3: return new FragmentThongDiep();
            default: return new FragmentHome();
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }
}
