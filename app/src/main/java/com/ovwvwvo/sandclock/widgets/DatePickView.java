package com.ovwvwvo.sandclock.widgets;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ovwvwvo.sandclock.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guang on 2017/12/7
 */

public class DatePickView extends LinearLayout implements WheelView.OnWheelViewListener {

    @BindView(R.id.wheel_year)
    WheelView yearWheel;
    @BindView(R.id.wheel_month)
    WheelView monthWheel;
    @BindView(R.id.wheel_day)
    WheelView dayWheel;

    private List<String> years = new ArrayList<>();
    private List<String> months = new ArrayList<>();
    private List<String> days = new ArrayList<>();

    private Calendar calendar = Calendar.getInstance();

    public DatePickView(Context context) {
        this(context, new Date());
    }

    public DatePickView(Context context, @Nullable Date defaultDate) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.view_calendar_switch, this, true);
        ButterKnife.bind(this);
        initData(defaultDate);
    }

    private void initData(Date defaultDate) {
        calendar.setTime(defaultDate);
        //填充 years
        int year = 1900;
        while (year <= 2099) {
            years.add(String.valueOf(year));
            year++;
        }
        //填充 months
        for (int month = 1; month <= 12; month++) {
            months.add(String.valueOf(month));
        }
        //填充 days
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= maxDay; day++) {
            days.add(String.valueOf(day));
        }
        yearWheel.setItems(years);
        yearWheel.setSeletion(calendar.get(Calendar.YEAR) - 1900);
        yearWheel.setOnWheelViewListener(this);
        monthWheel.setItems(months);
        monthWheel.setSeletion(calendar.get(Calendar.MONTH));
        monthWheel.setOnWheelViewListener(this);
        dayWheel.setItems(days);
        dayWheel.setSeletion(calendar.get(Calendar.DAY_OF_MONTH) - 1);
    }

    public Date getDate() {
        calendar.set(Integer.valueOf(yearWheel.getSeletedItem()),
                Integer.valueOf(monthWheel.getSeletedItem()) - 1,
                Integer.valueOf(dayWheel.getSeletedItem()));
        return calendar.getTime();
    }

    @Override
    public void onSelected(int selectedIndex, String item) {
        //更新 days 数据
        calendar.set(Integer.valueOf(yearWheel.getSeletedItem()),
                Integer.valueOf(monthWheel.getSeletedItem()),
                0);
        days.clear();
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= maxDay; day++) {
            days.add(String.valueOf(day));
        }
        dayWheel.setItems(days);
    }

}
