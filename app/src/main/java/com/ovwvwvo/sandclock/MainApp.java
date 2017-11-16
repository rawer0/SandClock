package com.ovwvwvo.sandclock;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by guang on 2017/11/15.
 */

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
