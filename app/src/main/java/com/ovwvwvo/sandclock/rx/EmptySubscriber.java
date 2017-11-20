package com.ovwvwvo.sandclock.rx;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by guang on 2017/11/15.
 */

public class EmptySubscriber<T> implements Subscriber<T> {


    @Override
    public void onSubscribe(Subscription s) {
        Log.i("###$", "onSubscribe");
        s.request(Integer.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        Log.i("###$", "doOnNext");

    }

    @Override
    public void onError(Throwable t) {
        Log.i("###$", "onError");

    }

    @Override
    public void onComplete() {
        Log.i("###$", "onComplete");

    }
}
