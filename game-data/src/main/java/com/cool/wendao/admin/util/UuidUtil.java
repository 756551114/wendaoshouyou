package com.cool.wendao.admin.util;

import cn.hutool.core.util.IdUtil;

public class UuidUtil {
    public static String uuid() {
        return IdUtil.fastSimpleUUID();
    }
}
