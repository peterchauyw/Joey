package com.example.os.joey_beta;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new HomeFragment(),"");
        viewPagerAdapter.addFragments(new NavigationFragment(),"");
        viewPagerAdapter.addFragments(new MessageFragment(), "");
        viewPagerAdapter.addFragments(new CharacterFragment(), "");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        final int[] icons = new int[]{
                R.drawable.ic_home, R.drawable.ic_bino,
                R.drawable.ic_heart, R.drawable.ic_bear};

        for(int i=0; i < 4; i++){
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }
    }
}
