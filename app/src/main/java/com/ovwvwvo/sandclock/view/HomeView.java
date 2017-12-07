package com.ovwvwvo.sandclock.view;

import com.ovwvwvo.sandclock.model.SandClockModel;

import java.util.List;

/**
 * Copyright ©2017 by rawer
 */

public interface HomeView extends BaseView {

    void onLoadComplete(List<SandClockModel> models);
}
