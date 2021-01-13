package com.example.fragmentpagertest;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment  implements ViewPager.OnPageChangeListener{

    private Button prevButton;
    private Button nextButton;

    private CustomViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       // getChildFragmentManager().beginTransaction().replace(R.id.placeholderFragment,new FirstFragment()).commit();
        // Inflate the layout for this fragment
                View view = inflater.inflate(R.layout.fragment_main, container, false);
                nextButton = view.findViewById(R.id.button);
                viewPager = view.findViewById(R.id.main_viewpager);
                myPagerAdapter = new MyPagerAdapter(getChildFragmentManager(),0);


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());

                myPagerAdapter.setFragmentList(fragments);

                viewPager.setAdapter(myPagerAdapter);
                viewPager.setOnPageChangeListener(this);
                viewPager.setPagingEnabled(true);

               // prevButton = view.findViewById(R.id.prev_button);
               // nextButton = view.findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });

 return view;
    }

    int currentPosition = 0;
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int newPosition) {

    FragmentLifecycle fragmentToShow = (FragmentLifecycle)myPagerAdapter.getItem(newPosition);
    fragmentToShow.onResumeFragment();
    fragmentToShow.onCreate();


    FragmentLifecycle fragmentTohide = (FragmentLifecycle)myPagerAdapter.getItem(currentPosition);
    fragmentTohide.onPauseFragment();

    currentPosition = newPosition;

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
