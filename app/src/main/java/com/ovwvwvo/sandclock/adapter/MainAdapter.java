package com.ovwvwvo.sandclock.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.ui.SandClockFragment;

/**
 * Created by guang on 2017/11/8.
 */

public class MainAdapter extends FragmentPagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return SandClockFragment.newInstance();
        } else if (position == 1) {
            return SandClockFragment.newInstance();
        } else {
            return SandClockFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
