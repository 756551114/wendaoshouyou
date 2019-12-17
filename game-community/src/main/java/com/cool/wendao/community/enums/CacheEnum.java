package com.cool.wendao.community.enums;

import lombok.Getter;

@Getter
public enum CacheEnum {

    /**
     * 用胡token
     */
    USER_TOKEN("user_token_", 30*24*60*60*1000);

    private String name;
    private long time;

    CacheEnum(String name, long time) {
        this.name = name;
        this.time = time;
    }
}
