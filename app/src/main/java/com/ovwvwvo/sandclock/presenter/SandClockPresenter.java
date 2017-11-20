package com.ovwvwvo.sandclock.presenter;

import com.ovwvwvo.sandclock.model.SandClockModel;
import com.ovwvwvo.sandclock.repo.SandClockDBRepo;
import com.ovwvwvo.sandclock.view.SandClockView;

import java.util.Date;

/**
 * Created by guang on 2017/11/8.
 */

public class SandClockPresenter {

    private SandClockView view;
    private SandClockDBRepo sandClockDBRepo;

    public SandClockPresenter(SandClockView sandClockView) {
        this.view = sandClockView;
        sandClockDBRepo = SandClockDBRepo.newInstance();
    }

    public void loadData() {
        sandClockDBRepo.load()
                .subscribe(sandClockModels -> {
                    view.onHideLoding();
                    view.onLoadComplete(sandClockModels);
                }, Throwable::printStackTrace);
    }

    public void setData() {
        Date date = new Date();
        sandClockDBRepo.addData(new SandClockModel("测试", date.getTime()));
    }

    public void onDestroy() {
        sandClockDBRepo.onDestroy();
    }
}