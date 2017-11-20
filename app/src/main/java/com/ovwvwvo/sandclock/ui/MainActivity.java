package com.ovwvwvo.sandclock.ui;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.adapter.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.viewPage)
    ViewPager viewPager;

    private boolean isShow = true;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void hideBootomNavigation() {
        if (!isShow) return;
        int top = navigation.getTop();
        startAnim(top, top + navigation.getHeight());
        isShow = false;
    }

    public void showBootomNavigation() {
        if (isShow) return;
        isShow = true;
        int top = navigation.getTop();
        startAnim(top + navigation.getHeight(), top);
    }

    private void startAnim(float startPosition, float endPosition) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(navigation, "y", startPosition, endPosition);
        objectAnimator.setDuration(350);
        objectAnimator.start();
    }
}
