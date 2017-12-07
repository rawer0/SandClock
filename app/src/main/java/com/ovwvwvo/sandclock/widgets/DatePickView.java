package com.ovwvwvo.sandclock.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ovwvwvo.sandclock.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guang on 2017/12/7.
 */

public class DatePickView extends LinearLayout {

    @BindView(R.id.wheel_year)
    WheelView yearWheel;
    @BindView(R.id.wheel_month)
    WheelView monthWheel;
    @BindView(R.id.wheel_day)
    WheelView dayWheel;

    List<String> years = new ArrayList<>();
    List<String> months = new ArrayList<>();
    List<String> days = new ArrayList<>();

    public DatePickView(Context context) {
        this(context, null);
    }

    public DatePickView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_calendar_switch, this, true);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //填充 yearWheel
        int year = 1900;
        while (year <= 2099) {
            years.add(String.valueOf(year));
            year++;
        }
        yearWheel.setItems(years);
        int currentYearIndex = Calendar.getInstance().get(Calendar.YEAR) - 1900;
        yearWheel.setSeletion(currentYearIndex);
        //填充 monthWheel

        //填充 dayWheel


    }
}
