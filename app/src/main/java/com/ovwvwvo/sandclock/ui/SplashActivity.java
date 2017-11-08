package com.ovwvwvo.sandclock.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ovwvwvo.sandclock.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright ©2016 by rawer
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.copyright)
    TextView copyright_tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        copyright_tv.setText(String.format(getString(R.string.copyright), getString(R.string.app_name)));
        next();
    }


    private void next() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
