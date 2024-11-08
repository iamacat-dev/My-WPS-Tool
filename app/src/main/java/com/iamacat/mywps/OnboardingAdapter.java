package com.iamacat.mywps;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class OnboardingAdapter extends FragmentPagerAdapter {

    public OnboardingAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OnboardingFragmentOne();
            case 1:
                return new OnboardingFragmentTwo();
            case 2:
                return new OnboardingFragmentThree();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // Total number of pages
    }
}