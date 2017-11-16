package com.ovwvwvo.sandclock.rx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by guang on 2017/11/15.
 */

public class EmptyObserver<T> implements Observer<T> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
