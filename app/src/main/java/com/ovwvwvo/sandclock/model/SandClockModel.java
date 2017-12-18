package com.ovwvwvo.sandclock.model;

import com.ovwvwvo.sandclock.skin.SkinId;

import io.realm.RealmObject;
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
    private String desc;   //默认为自动匹配（还有、已经）
    private int unit = Unit.DALY.ordinal();  //单位(年、月、天、小时、分、秒)

    private Integer repeat = 0;  //重复规则
    private Integer priority = 0;   //优先度
    private String remark;   //备注

    private Integer skin = SkinId.SKIN_001;//前两位控制位置(00-主界面; 01-详情页; 10-widget页面) 后8位控制布局 id

    public SandClockModel() {

    }

    public SandClockModel(long targetDate) {
        this.targetDate = targetDate;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
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

    public Integer getSkin() {
        return skin;
    }

    public void setSkin(Integer skin) {
        this.skin = skin;
    }
}
