package com.example.android2exam;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {

            case 0:
                return TabFragment.newInstance("First");

            case 1:
                return TabFragment.newInstance("Second");

            case 2:
                return TabFragment.newInstance("Third");

            default:
                return TabFragment.newInstance("First");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
