package com.ovwvwvo.sandclock.view;

/**
 * Created by guang on 2017/12/7.
 */

public interface BaseView {
    void onShowLoading();

    void onHideLoding();

    default void onViewResume() {
    }

    default void onViewDestory() {
    }
}
