package com.iamacat.mywps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.stericson.RootTools.RootTools;

public class OnboardingFragmentTwo extends Fragment {

    private CustomViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fragment এর layout Inflate করা
        View view = inflater.inflate(R.layout.fragment_onboarding_two, container, false);

        // ViewPager অ্যাক্সেস করতে MainActivity থেকে পেজার ইনস্ট্যান্স আনো
        viewPager = (CustomViewPager) getActivity().findViewById(R.id.viewPager);

        // Next বোতামের রেফারেন্স নিয়ে আসা
        Button btnNext = view.findViewById(R.id.btnNext);

        // Next বোতামের জন্য Click Listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RootTools.isAccessGiven();
                // পরবর্তী পেজে নিয়ে যাওয়ার জন্য setCurrentItem()
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });

        return view;
    }
}