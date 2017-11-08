package com.ovwvwvo.sandclock.ui;

import android.support.v4.app.Fragment;

/**
 * Created by guang on 2017/11/8.
 */

public class SecondFragment extends Fragment {

    private static SecondFragment singInstance = new SecondFragment();

    public static SecondFragment newInstance() {
        return singInstance;
    }

}
