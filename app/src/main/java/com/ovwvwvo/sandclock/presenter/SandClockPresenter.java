package com.ovwvwvo.sandclock.presenter;

import com.ovwvwvo.common.utils.ToastMaster;
import com.ovwvwvo.sandclock.repo.SandClockDBRepo;
import com.ovwvwvo.sandclock.rx.EmptyObserver;

import io.reactivex.schedulers.Schedulers;

/**
 * Created by guang on 2017/11/8.
 */

public class SandClockPresenter {

    public void loadData() {
        SandClockDBRepo.newInstance().load()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe((subscription) -> ToastMaster.showToastMsg("开始"))
                .doOnTerminate(() -> ToastMaster.showToastMsg("终端"))
                .doOnError((e) -> ToastMaster.showToastMsg("出错"))
                .doOnComplete(() -> ToastMaster.showToastMsg("结束"))
                .subscribe(new EmptyObserver());
    }
}
