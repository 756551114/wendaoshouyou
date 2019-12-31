package org.linlinjava.litemall.wx.core;

import cn.hutool.core.io.FileUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Inint {


    @PostConstruct
    public void init() {
        deleteTemp();
    }

    /**
     * 删除临时文件
     */
    public void deleteTemp() {
        String temp = "/home/temp";
        boolean exist = FileUtil.exist(temp);
        if(!exist) {
            FileUtil.del(temp);
        }
    }


}
