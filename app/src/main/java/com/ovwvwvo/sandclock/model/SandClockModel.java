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
    private String name;
    private long targetDate;

    //以下为可以为 null 的字段
    private Integer repeat = 0;//重复规则
    private Integer priority = 0;//优先度
    private Integer skin = 0;
    private String remark;
    private int unit = Unit.DALY.ordinal();//单位(年、月、天、小时、分、秒)

    @Ignore
    private long interval;//间隔

    public SandClockModel() {
    }

    public SandClockModel(String content, long targetDate) {
        this.name = content;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getRepeat() {
        return repeat;
    }

    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
