package com.ovwvwvo.sandclock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Copyright ©2016 by rawer
 */

public class GuideActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(mContext, SplashActivity.class));
        finish();
    }
}
