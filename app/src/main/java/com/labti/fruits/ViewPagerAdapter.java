package com.labti.fruits;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT =2;

    private String judulTab[] = new String[]{
            "Bahasa Indonesia", "Bahasa Inggris",
    };

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override public Fragment getItem(int arg0){
        PagerActivity myFragment=new PagerActivity();
        Bundle data =new Bundle();
        data.putInt("current_page",arg0+1);
        myFragment.setArguments(data);
        return myFragment;
    }

    @Override public int getCount(){
        return PAGE_COUNT;
    }

    @Override public CharSequence getPageTitle(int position){

        return judulTab[position];
    }

}