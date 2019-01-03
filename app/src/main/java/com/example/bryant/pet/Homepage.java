package com.example.bryant.pet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bryant.pet._sliders.FragmentSlider;
import com.example.bryant.pet._sliders.SliderIndicator;
import com.example.bryant.pet._sliders.SliderPagerAdapter;
import com.example.bryant.pet._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends Fragment {

    ImageButton mProvider;
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;
    private View rootView;
    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    public Homepage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_homepage,container,false);
        // Inflate the layout for this fragment
        mProvider = rootView.findViewById(R.id.imageButton2);
        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        mProvider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Testing.class);
                startActivity(i);
            }
        }
        );

        return rootView;
    }


    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("drawable/expo1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://weliveinaflat.com/wp-content/uploads/2018/03/sg-pet-expo-header.jpg"));
        fragments.add(FragmentSlider.newInstance("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_OYlXJfPW2H9yCvGnBI7En_G4eHk_n30tTop-U1iQuzRTgiJ6"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }


}
