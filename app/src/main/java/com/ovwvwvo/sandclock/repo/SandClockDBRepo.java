package com.ovwvwvo.sandclock.repo;

import com.ovwvwvo.sandclock.model.SandClockModel;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

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
        return realm.where(SandClockModel.class)
                .findAll()
                .asFlowable()
                .subscribeOn(AndroidSchedulers.mainThread());
    }

    public void addData(SandClockModel sandClockModel) {
        realm.beginTransaction();
        sandClockModel.setId(generateNewPrimaryKey());
        realm.insert(sandClockModel);
        realm.commitTransaction();
    }

    private long generateNewPrimaryKey() {
        RealmResults<SandClockModel> result = realm.where(SandClockModel.class).findAllSorted("id", Sort.ASCENDING);
        if (result.isEmpty())
            return 0;
        else
            return result.last().getId();
    }

    public void onDestroy() {
        realm.close();
    }

}
