package com.ovwvwvo.sandclock.repo;

import com.ovwvwvo.sandclock.model.SandClockModel;

import io.reactivex.Flowable;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by guang on 2017/11/15.
 */

public class SandClockDBRepo {

    private Realm realm;
    private static SandClockDBRepo sandClockDBRepo = new SandClockDBRepo();

    private SandClockDBRepo() {
        realm = Realm.getDefaultInstance();
    }

    public static SandClockDBRepo newInstance() {
        return sandClockDBRepo;
    }

    public Flowable<RealmResults<SandClockModel>> load() {
        return realm.asFlowable()
                .map(realm -> realm.where(SandClockModel.class).findAllSorted("id"));
    }
}
