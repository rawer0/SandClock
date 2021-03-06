package com.ovwvwvo.sandclock.rx;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by guang on 2017/11/15.
 */

public class EmptyObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {
        Log.i("###$", "onSubscribe");
    }

    @Override
    public void onNext(T t) {
        Log.i("###$", "onNext");

    }

    @Override
    public void onError(Throwable e) {
        Log.i("###$", "onError");

    }

    @Override
    public void onComplete() {
        Log.i("###$", "onComplete");

    }
}
