package com.example.kstedman.mathapplication.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kstedman.mathapplication.models.WolframResponseModel;
import com.example.kstedman.mathapplication.ui.ResponseDetailFragment;

import java.util.ArrayList;

public class ResponsePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<WolframResponseModel> mReponses;

    public ResponsePagerAdapter(FragmentManager fm, ArrayList<WolframResponseModel> responses) {
        super(fm);
        mReponses = responses;
    }

    @Override
    public Fragment getItem(int position) {
        return ResponseDetailFragment.newInstance(mReponses.get(position));
    }

    @Override
    public int getCount() {
        return mReponses.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mReponses.get(position).getTitle();
    }
}
