package com.cool.wendao.community.core;

public enum Deleted {

    /**
     * 未删除
     */
    NOT_DELETED(0, "未删除"),

    /**
     * 已删除
     */
    IS_DELETED(1, "已删除");

    private final int value;
    private final String name;

    private Deleted(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public int value() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
