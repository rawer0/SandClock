package com.ovwvwvo.sandclock.ui;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.adapter.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

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
                case R.id.navigation_skin:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_me:
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
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
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

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0)
            navigation.setSelectedItemId(R.id.navigation_home);
        else if (position == 1)
            navigation.setSelectedItemId(R.id.navigation_skin);
        else if (position == 2)
            navigation.setSelectedItemId(R.id.navigation_me);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
