package com.ovwvwvo.sandclock.utils;

import com.ovwvwvo.sandclock.model.Constants;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by guang on 2017/12/15.
 */

public class TimeUtil {

    public static long getDayOfInterval(long targetTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return (targetTime - calendar.getTimeInMillis()) / Constants.DAY_TIME_LENGTH;
    }

}
