package com.ovwvwvo.sandclock.model;

/**
 * Created by guang on 2017/11/15
 */

public enum Unit {
    SECONDS("秒", 0),
    MINUTE("分", 1),
    HOUR("小时", 2),
    DALY("天", 3),
    WEEK("周", 4),
    MONTH("月", 5),
    YEAR("年", 6);

    private String name;
    private int value;

    Unit(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
