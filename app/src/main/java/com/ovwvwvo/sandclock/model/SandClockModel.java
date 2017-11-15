package com.ovwvwvo.sandclock.model;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Required;

/**
 * Created by guang on 2017/11/8.
 */

public class SandClockModel extends RealmObject {

    private long id;//在 Realm 中基本类型不允许为 null
    @Required
    private String content;
    private long targetDate;

    private Integer skin = 0;//可以为 null
    private int unit = Unit.DALY.ordinal();//单位(年、月、天、小时、分、秒) 可以为 null

    @Ignore
    private long interval;//间隔

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(long targetDate) {
        this.targetDate = targetDate;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Integer getSkin() {
        return skin;
    }

    public void setSkin(Integer skin) {
        this.skin = skin;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}
