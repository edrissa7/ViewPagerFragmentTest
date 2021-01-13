package com.example.fragmentpagertest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private ViewPager viewPager;
     private MyPagerAdapter myPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  getSupportFragmentManager().beginTransaction().replace(R.id.m,new MainFragment()).commit();
       /* viewPager = findViewById(R.id.main_viewpager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),0);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());

        myPagerAdapter.setFragmentList(fragments);

        viewPager.setAdapter(myPagerAdapter);*/

    }
}