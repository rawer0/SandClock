package com.ovwvwvo.sandclock;

import android.app.Application;

import com.ovwvwvo.common.AppWrapper;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by guang on 2017/11/15.
 */

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppWrapper.getInstance().setAppContext(this);
        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
        RealmConfiguration mConfig = new RealmConfiguration.Builder()
                .name("SandClock.realm") //在/data/data/package-name/files/
                .schemaVersion(1)
                .build();
        Realm.setDefaultConfiguration(mConfig);
    }
}
