package com.ovwvwvo.sandclock.presenter;

import com.ovwvwvo.common.utils.ToastMaster;
import com.ovwvwvo.sandclock.R;
import com.ovwvwvo.sandclock.model.SandClockModel;
import com.ovwvwvo.sandclock.repo.SandClockDBRepo;
import com.ovwvwvo.sandclock.view.AddView;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by guang on 2017/12/6.
 */

public class AddPresenter {
    private AddView view;
    private SandClockDBRepo sandClockDBRepo;

    public AddPresenter(AddView addView) {
        this.view = addView;
        sandClockDBRepo = SandClockDBRepo.newInstance();
    }

    public void addDay(SandClockModel model) {
        Observable.create((ObservableOnSubscribe<Boolean>) emitter -> {
            try {
                sandClockDBRepo.addData(model);
                emitter.onNext(true);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        }).subscribe(bo -> {
            ToastMaster.showToastMsg(R.string.add_complete);
            view.onAddComplete();
        }, throwable -> {
            ToastMaster.showToastMsg(R.string.add_failure);
            throwable.printStackTrace();
        });
    }

}
